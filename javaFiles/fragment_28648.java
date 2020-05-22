lst_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View view, final int position, long id) {
                List o = (List) adapter.getItem(position);
                String month = o.getMonthAndYear();
                int id1 = Integer.parseInt(o.getID()+"");
     }