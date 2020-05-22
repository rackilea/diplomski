ArrayList<CustomClass> newList = new ArrayList<CustomClass>();

    private void eventforloop() {
        final UsersAdapter usersAdapter = new UsersAdapter(getApplicationContext(), newList);
        anouncement_list.setAdapter(usersAdapter);
        progressBar.setVisibility(View.INVISIBLE);

        for (z = 0; z < jas1.length; z++) {
            jas1[z] = jas1[z].trim();

            DocumentReference data = db.collection("schools").document(Sname).collection("anouncements").document(jas1[z]);
            data.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String adate = String.valueOf(documentSnapshot.get("date")).trim();
                    String adescr = String.valueOf(documentSnapshot.get("desc")).trim();
                    String aheaing = String.valueOf(documentSnapshot.get("heading")).trim();

                    CustomClass customClass = new CustomClass();
                    customClass.setAdate(getDate(adate));
                    customClass.setAdescr(adescr);
                    customClass.setAheaing(aheaing);

                    newList.add(customClass);
                    Collections.sort(newList, new Comparator<CustomClass>() {
                        @Override
                        public int compare(CustomClass o1, CustomClass o2) {
                            return o1.getAdate().compareTo(o2.getAdate());
                        }
                    });

                    usersAdapter.notifyDataSetChanged();
                }
            });

        }

    }

    public class UsersAdapter extends ArrayAdapter<CustomClass> {
        public UsersAdapter(Context context, ArrayList<CustomClass> customClass) {
            super(context, 0, customClass);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.anouncementxml1, parent, false);
            }

            // Lookup view for data population
            TextView tDate = convertView.findViewById(R.id.anndate);
            TextView theading = convertView.findViewById(R.id.annheading);
            JustifiedTextView tdesc = convertView.findViewById(R.id.anndescri);
            CustomClass customClass = getItem(position);

            android.text.format.DateFormat df = new android.text.format.DateFormat();
            tDate.setText(df.format("dd-MM-yyyy",customClass.adate).toString());
            theading.setText(customClass.aheaing);
            tdesc.setText(customClass.adescr);
            return convertView;
        }
    }

    private Date getDate(String yooo) {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MMM-yyyy");
        Date newDate = null;
        try {
            newDate = spf.parse(yooo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newDate;
    }