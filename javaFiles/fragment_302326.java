private class MyListAdapter extends ArrayAdapter<caloocanDB> {
        public static ArrayList<coloocanDB> tempRestList = new ArrayList<>();
        public static ArrayList<coloocanDB> restList = new ArrayList<>();
        public MyListAdapter(ArrayList<caloocanDB> objects){
            super(caloocan.this, R.layout.caloocan_list_view, objects);        tempRestList = new ArrayList<>();
            restList = objects;
            tempRestList.addAll(objects);
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View caloocanView = convertView;
            if (caloocanView == null)
                caloocanView = getLayoutInflater().inflate(R.layout.caloocan_list_view, parent, false);

            caloocanDB restaurant = restList.get(position);
            //FILL VIEW
            ImageView imageView = (ImageView)caloocanView.findViewById(R.id.imageView);
            imageView.setImageResource(restaurant.getIconID());
            // RESTAU NAME
            TextView restauName = (TextView)caloocanView.findViewById(R.id.resnameTxt);
            restauName.setText(restaurant.getResname());
            //RESTAU LOCA
            TextView location = (TextView)caloocanView.findViewById(R.id.reslocTxt);
            location.setText(restaurant.getResloc());
            //FOOD TYPE
            TextView restype = (TextView)caloocanView.findViewById(R.id.restypeTxt);
            restype.setText(restaurant.getType());
            return caloocanView;
        }


     public void filter(String filter) {
      restList.clear();
      if(filter != null && filter.trim().length() > 0){
        for (caloocanDB element : tempRestList){
          if (element.getResname().contains(filter) || element.getType().contains(filter) || element.getResLoc().contains(filter))
             restList.add(element);
          }
      }else{
             restList.addAll(tempRestList);
      } 
      super.notifyDataSetChanged();
   }
}