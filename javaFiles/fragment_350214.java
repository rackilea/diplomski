public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ArrayList<String>clicklat= new ArrayList<String>(history.get(position).getLati());

            ArrayList<String>clicklong= new ArrayList<String>(history.get(position).getLongi());

            ArrayList<String>dttime= new ArrayList<String>(history.get(position).getDatetime());

            Intent i = new Intent(HistoryActivity.this, DetailsActivity.class);
            i.putStringArrayListExtra("clicklat", clicklat);
            i.putStringArrayListExtra("clicklong", clicklong);
            i.putStringArrayListExtra("clickdatetime", dttime);
            startActivity(i);
      }