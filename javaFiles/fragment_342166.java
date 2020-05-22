TextView textView = (TextView) mView.findViewById(R.id.entryRowTextView);


textView.setOnClickListener(new OnClickListener() {

                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            // TODO Auto-generated method stub
                            if(Entry.totalPageNumber>1){
                                //if no more than one page exist no need to navigate
                                Log.d(EKSI, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                if(show == false){
                                    findViewById(R.id.back).setVisibility(View.VISIBLE);
                                    findViewById(R.id.forward).setVisibility(View.VISIBLE);
                                    findViewById(R.id.start).setVisibility(View.VISIBLE);
                                    findViewById(R.id.last).setVisibility(View.VISIBLE);
                                    show=true;
                                }else if(show==true){
                                    findViewById(R.id.back).setVisibility(View.GONE);
                                    findViewById(R.id.forward).setVisibility(View.GONE);
                                    findViewById(R.id.start).setVisibility(View.GONE);
                                    findViewById(R.id.last).setVisibility(View.GONE);
                                    show=false;
                                }
                            }
                        }
                    });