builder.setTitle("Present?")
                            .setMessage ("Present or Absent:").setPositiveButton ("Present", new DialogInterface.OnClickListener () {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try{
                                //view.setBackgroundColor (getColor (android.R.color.holo_green_light));
                                Calendar calendar = Calendar.getInstance ();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("dd MMM yyyy");
                                DatabaseReference user = databaseReference.child ("Attendence");
                                DatabaseReference date = user.child (simpleDateFormat.format (calendar.getTime ()));
                                DatabaseReference name = date.child (itemname);
                                name.setValue ("Present");
                                adapterView.updateView(true, i); // to get the present value form your alert;

                            }catch (Exception e){
                                Toast.makeText (MainActivity.this, e.getMessage (), Toast.LENGTH_SHORT).show ();
                            }
                        }
                    }).setNegativeButton ("Absent", new DialogInterface.OnClickListener () {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Calendar calendar = Calendar.getInstance ();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("dd MMM yyyy");
                            DatabaseReference user = databaseReference.child ("Attendence");
                            DatabaseReference date = user.child (simpleDateFormat.format (calendar.getTime ()));
                            DatabaseReference name = date.child (itemname);
                            name.setValue ("Absent");
                            adapterView.updateView(false, i); // to get the absent value form your alert;

                        }
                    });