deleteButton = (ImageButton) convertView.findViewById(R.id.xButtonID);
deleteButton.setTag(position);
deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    itemList.remove(pos);
                    notifyDataSetChanged();
                    notifyDataSetInvalidated();
                }
            });