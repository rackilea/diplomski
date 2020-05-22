private class Adapter extends BaseAdapter {
            private ArrayList<String> array;
            private Context ctx;

            public Adapter(Context ctx) {
                this.ctx = ctx;
                array = new ArrayList<String>();
            }

            @Override
            public int getCount() {
                return this.array.size();
            }

            @Override
            public Object getItem(int position) {
                return this.array.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            /**
             * add a String Item in a List
             * 
             * @param item
             */
            public void addItem(String item) {
                this.array.add(item);
                this.notifyDataSetChanged();
            }

            /**
             * Delete an Item from a List
             * 
             * @param position
             */
            public void deleteItem(int position) {
                this.array.remove(position);
                this.notifyDataSetChanged();
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View newView;

                if (convertView == null) {
                    newView = View.inflate(ctx, R.layout.item_layout, null);
                } else {
                    newView = convertView;
                }

                String txt = (String) this.getItem(position);

//   Here is what you're looking for:
                ((TextView) newView.findViewById(R.id.item_numb)).setText(""
                        + (position + 1) + ". ");
//   End;
                ((TextView) newView.findViewById(R.id.item_text)).setText(txt);

                return newView;
            }

        }