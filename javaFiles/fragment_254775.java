Item item = (Item)getItem(i);
Button add=(Button)v.findViewById(R.id.add);
add.setTag(i);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v)  {
        int position = (int)v.getTag();
        //do something with item object
        Item item = items.get(position);
        list listItem = new list(item.colorId, item.name, Integer.toString(co[position]), Integer.toString(no[position]));
        rowitems.add(listItem);       
    }
});