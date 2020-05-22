row.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(DisplayData.this, UpdatePage.class);
                        intent.putExtra("name", name2);
                        intent.putExtra("date",date2);
                        startActivity(intent);
                    }
                });