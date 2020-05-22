@Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item.getItemId() == android.R.id.home) {
                    onBackPressed();
                    return true;
                }else if(item.getItemId() == R.id.email){
                        Toast.makeText(getBaseContext(), "You selected Email", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.print){
                         Toast.makeText(getBaseContext(), "You selected Print", Toast.LENGTH_SHORT).show();

                }
                return super.onOptionsItemSelected(item);
            }