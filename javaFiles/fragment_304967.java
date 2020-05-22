Snackbar snackbar = Snackbar
                        .make(view, name + " Removed!", Snackbar.LENGTH_LONG)
                        .setActionTextColor(context.getResources().getColor(R.color.dot_dark_screen1))
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                context = view.getContext();
                                final User mDataSet3 = mDataSet.get(getAdapterPosition());;
                                String url = mDataSet3.getEmail();
                                String name = mDataSet3.getName();
                                String query = "INSERT INTO faces (name,url) VALUES('"+name+"', '"+url+"');";
                                db.execSQL(query);
                                mDataSet.add(mDataSet3);
                                 notifyDataSetChanged();
                                Snackbar snackbar3 = Snackbar.make(view, name + " Favorited!", Snackbar.LENGTH_SHORT);
                                snackbar3.show();
                            }
                        });
                snackbar.show();