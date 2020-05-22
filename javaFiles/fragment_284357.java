final TextView _dpResult=(TextView)convertView.findViewById(R.id.dpResult);
_dpResult.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                DialogFragment newFragment = new SelectDateFragment( );
                                newFragment.show(getFragmentManager(), "DatePicker");
                            }
                        });