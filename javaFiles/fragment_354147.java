@Override
 public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView)   holder.itemView.findViewById(R.id.list_item);
            view.setText(listItems.get(position).toString());
            holder.itemView.setTag(position);
            int textColorId = R.color.white; // Default color
            switch (position) {
                case 0:
                    textColorId = R.color.red; break;
                case 1:
                    textColorId = R.color.yellow; break;
                case 2:
                    textColorId = R.color.green; break;
            }
            view.setTextColor(getResources().getColor(textColorId));
  }