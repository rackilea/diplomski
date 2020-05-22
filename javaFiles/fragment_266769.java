@Override
   public MyMenuItem getItem(int position) { // << subclasses can use subtypes in overridden methods!
       return menuItems.get(position);
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
       ...
       MyMenuItem row_pos = getItem(position);