btnCount.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   count++;
                                   txtCount.setText(String.valueOf(count));
                                }
                            });