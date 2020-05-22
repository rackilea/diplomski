menu_home_button.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        // Menu text
        final String[] items = {"Home", "How To", "Rate", "About"};

        // Menu Icons in Drawable
        final Drawable[] item_icons = {
            getResources().getDrawable(R.drawable.home_icon),
            getResources().getDrawable(R.drawable.how_to_icon),
            getResources().getDrawable(R.drawable.rate_icon),
            getResources().getDrawable(R.drawable.about_icon),
        };

        ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_menu_dialog, items) {
            ViewHolder holder;

            class ViewHolder {
                ImageView icon;
                TextView title;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                final LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.custom_menu_dialog, null);
                    holder = new ViewHolder();
                    holder.icon = (ImageView) convertView.findViewById(R.id.icon);
                    holder.title = (TextView) convertView.findViewById(R.id.title);
                    convertView.setTag(holder);
                } else {
                    // view already defined, retrieve view holder
                    holder = (ViewHolder) convertView.getTag();
                }

                holder.title.setText(items[position]);
                holder.icon.setImageDrawable(item_icons[position]);
                return convertView;
            }
        };

        Toast.makeText(getApplicationContext(), "Long Press works...", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder menu_dialog = new AlertDialog.Builder(WebViewActivity.this); 

        menu_dialog.setTitle(getResources().getString("My Menu Name");
        menu_dialog.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
            //Toast.makeText(WebViewActivity.this, "You selected: " + items[item], Toast.LENGTH_LONG).show();
                switch (item) {
                    case 0:
                        open_home();
                        break;
                    case 1: // HOW TO
                        open_how_to();
                        break;
                    case 2:
                        open_rate();
                        break;
                    case 3: // ABOUT
                        open_about();
                        break;
                    default: // Do Case 0
                        open_home();
                        break;
                }
                dialog.dismiss();
           }
       });
       AlertDialog alert = menu_dialog.create();
       alert.show();
       return true;
    }
});