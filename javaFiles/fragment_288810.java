public class StateFragment extends Fragment implements StatAdapter.OnMenuItemClickListener {
    private final int PERMISSION_CONTACT = 10003;
    private final int PICK_CONTACT = 10;
    @BindView(R.id.list_stats)
    ListView mStatList;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    EditText edtName, edtNumber;
    private Activity mActivity;
    private StatAdapter mAdapter;
    private Dialog mWaitDialog;
    ApiInterface apiService;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        mActivity = getActivity();
        apiService = ApiUtils.getAPIService(getContext());

        ButterKnife.bind(this, view);
        NumberData.getInstance();
        mAdapter = new StatAdapter(mActivity, new ArrayList<String>(),this);
        mStatList.setAdapter(mAdapter);
        mStatList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stat stat = mAdapter.getStat(position);
                Intent intent = new Intent(mActivity, DetailLogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(DetailLogActivity.DATA_OBJ, stat);
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        mWaitDialog = new Dialog(mActivity);
        mWaitDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mWaitDialog.setContentView(R.layout.dialog_wait);
        if (mWaitDialog.getWindow() != null) {
            mWaitDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        mWaitDialog.setCancelable(false);

        return view;
    }

    private void contact_permission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mActivity.checkSelfPermission(android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                AlertManager.createSingleCallbackAlert(mActivity, "We Need Your Permission",
                        "Please Grant Permission to Read Contacts to Access Number.", false, "OK",
                        new DialogInterface.OnClickListener() {
                            @TargetApi(23)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, PERMISSION_CONTACT);
                            }
                        });
            } else
                getContact();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_stats,menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.actionCompare){
            compare();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CONTACT: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getContact();
                } else {
                    Toast.makeText(mActivity.getApplicationContext(), "You Can Not Load Number from Contact", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void getContact() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT);
    }

    private void refreshData() {
        NumberData.getInstance().mData.clear();
        mAdapter.clearData();
        apiService.getNumbers(NumberData.getInstance().mUserEmail).enqueue(new retrofit2.Callback<GetNumberCallback>() {
            @Override
            public void onResponse(retrofit2.Call<GetNumberCallback> call, retrofit2.Response<GetNumberCallback> response) {
                try {
                    GetNumberCallback numberCallback = response.body();

                    if (numberCallback.getCode() == 1) {

                        for (int i = 0; i < numberCallback.getNumber().size(); i++) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                            Date mDate = sdf.parse(numberCallback.getLastOnline().get(i));
                            long lastOnlineTime = mDate.getTime();
                            NumberData.getInstance().mData.add(new Stat(numberCallback.getName().get(i), numberCallback.getNumber().get(i),

                                    numberCallback.getStatus().get(i)==1, formatDate(lastOnlineTime)));
                        }
                        mAdapter.setData(NumberData.getInstance().mData);
                    } else {
                        AlertManager.createSingleCallbackAlert(mActivity, "Error", "Server Problem",
                                false, "Retry", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                    }
                } catch (Exception pE) {

                }
                if (swipeRefresh.isRefreshing()) {
                    mActivity.runOnUiThread((new Runnable() {
                        @Override
                        public void run() {
                            swipeRefresh.setRefreshing(false);
                        }
                    }));
                }

            }

            @Override
            public void onFailure(retrofit2.Call<GetNumberCallback> call, Throwable t) {
                call.cancel();
                AlertManager.createSingleCallbackAlert(mActivity, "Unknown Error",
                        "Error reaching server", false, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                if (swipeRefresh.isRefreshing()) {
                    mActivity.runOnUiThread((new Runnable() {
                        @Override
                        public void run() {
                            swipeRefresh.setRefreshing(false);
                        }
                    }));
                }
            }
        });
    }



    @Override
    public void onResume() {
        if (mAdapter != null) {
            //mAdapter.setData(NumberData.getInstance().mData);
            refreshData();
        }
        super.onResume();
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        switch (reqCode) {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = mActivity.managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                        String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                        if (hasPhone.equalsIgnoreCase("1")) {
                            Cursor phones = mActivity.getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                                    null, null);
                            assert phones != null;
                            phones.moveToFirst();
                            edtNumber.setText(phones.getString(phones.getColumnIndex("data1")));
                            phones.close();
                        }
                        edtName.setText(c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));


                    }
                }
                break;
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd MMM, HH:mm:ss", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String formatDate(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd MMM, HH:mm:ss ", Locale.US);
        Date date = new Date(time);
        return dateFormat.format(date);
    }

    @Override
    public void onGetCSVClick() {
        Toast.makeText(mActivity, "Get CSV", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNotificationOffClick() {
        Toast.makeText(mActivity, "Notification Off", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNotificationOnClick() {
        Toast.makeText(mActivity, "Notification On", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNumberDetailsClick() {
        Toast.makeText(mActivity, "Number Details", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveNumberClick() {
        Toast.makeText(mActivity, "Remove Number", Toast.LENGTH_SHORT).show();
    }
}