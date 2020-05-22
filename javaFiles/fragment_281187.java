final TextView txtSubtitle = viewHolder.itemView.findViewById(R.id.tv_tv_B);
....


 cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(txtSubtitle.getVisibility() == View.GONE){
                                expandTV(txtSubtitle);
                            } else {
                                collapseTV(txtSubtitle);
                            }
                        }
                    });