public Object instantiateItem(View collection, int position) {

   LayoutInflater inflater = (LayoutInflater) collection.getContext()
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   View view = inflater.inflate(R.layout.common_layout, null);
   switch (position) {
       case 0:
         ((TextView)view.findViewById(R.id.text)).setText("One");
         break;
       case 1:
         ((TextView)view.findViewById(R.id.text)).setText("Two");
         break;
       case 2:
         ((TextView)view.findViewById(R.id.text)).setText("Three");
         break;
       case 3:
         ((TextView)view.findViewById(R.id.text)).setText("Four");
         break;
       case 4:
         ((TextView)view.findViewById(R.id.text)).setText("Five");
         break
     }

    ((ViewPager) collection).addView(view, 0);
    return view;
 }