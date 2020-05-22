public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.time_list_row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView.findViewById(R.id.day_textview);
            holder.text2 = (TextView) convertView.findViewById(R.id.date_textview);
            holder.text3 = (TextView) convertView.findViewById(R.id.times_this_day_textview);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        String dayNames[] = new DateFormatSymbols().getWeekdays();
        holder.text1.setVisibility(View.VISIBLE);
        holder.text2.setVisibility(View.VISIBLE);

        //Initialize list
        if (position < 1) {
            holder.text1.setText(dayNames[allPunches[position].get(Calendar.DAY_OF_WEEK)]);
            holder.text2.setText(formatDate(allPunches[position]));
        }
        else {
            //Show day and date if not same as last
            holder.text1.setText(dayNames[allPunches[position].get(Calendar.DAY_OF_WEEK)]);
            holder.text2.setText(formatDate(allPunches[position]));

            if (formatDate(allPunches[position]).contentEquals(formatDate(allPunches[position-1]))) {
                holder.text1.setVisibility(View.GONE);
                holder.text2.setVisibility(View.GONE);
            }
        }

        holder.text3.setText(formatTime(allPunches[position], true));

        //Color in/out punches
        if (position%2 == 0) {
            holder.text3.setTextColor(Color.GREEN);
        }
        else {
            holder.text3.setTextColor(Color.RED);
        }

        return convertView;
    } //end getView()

    static class ViewHolder {
        public TextView text1;
        TextView text2;
        TextView text3;
    }
} //end EfficientAdapter