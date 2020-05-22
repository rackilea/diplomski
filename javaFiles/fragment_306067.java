public static final int DATE_PICKER = 1;
            public static final int TIME_PICKER = 2;
            public static final int DIALOG = 3;

            Context mContext;
            String mMessage;
            boolean finishActivity;

           // private Fragment mCurrentFragment;
            Activity mActivity;

            /**
             *  this constructor is used for datepicker & Timepicker
             */
            public CustomDialogFragment (Fragment fragment ) {
            //        mCurrentFragment = fragment;
            }

            public CustomDialogFragment (Activity mActivity ) {
                this.mActivity = mActivity;
        }

            /**
             *  this constructor is used for simple dialog fragment
             */
            public CustomDialogFragment(Context context, String message, final boolean finishActivity) {
                mContext = context;
                mMessage = message;
                this.finishActivity = finishActivity;
            }



            public Dialog onCreateDialog(Bundle savedInstanceState) {
                Bundle bundle = new Bundle();
                bundle = getArguments();
                int id = bundle.getInt("dialog_id");
                switch (id) {
                case DATE_PICKER:
                    return new DatePickerDialog(getActivity(),
                            (OnDateSetListener)mActivity, bundle.getInt("year"),
                            bundle.getInt("month"), bundle.getInt("day"));

               case TIME_PICKER:
                    return new TimePickerDialog(getActivity(),
                            (OnTimeSetListener)mActivity,bundle.getInt("hour"),
                            bundle.getInt("minute"), true);

               case DIALOG:
                   AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                   alertDialogBuilder.setTitle(R.string.app_name);
                   alertDialogBuilder.setMessage(mMessage);
                   alertDialogBuilder.setIcon(R.drawable.ic_launcher);
                   alertDialogBuilder.setCancelable(false);
                   alertDialogBuilder.setPositiveButton(
                            getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {

                       @Override
                       public void onClick(DialogInterface dialog, int arg1) {

                           dialog.dismiss();
                           if (finishActivity == true) {
                               Activity act = (Activity) mContext;
                               act.finish();
                           }

                       }
                   });
                   alertDialogBuilder.setNegativeButton(getResources().getString(R.string.cancel_btn_title), new DialogInterface.OnClickListener() {

                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           CustomDialogFragment.this.dismiss();
                       }
                   });


                   return alertDialogBuilder.create();

                }

               //Define your custom dialog or alert dialog here and return it.
               return new Dialog(getActivity());
            }
        }