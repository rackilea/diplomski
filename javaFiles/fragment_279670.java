public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.friends_list_item, null);

            holder = new ViewHolder();

            holder.textTitle = (TextView) convertView
                    .findViewById(R.id.textTitle);
            holder.messageListTitle = (ImageView) convertView
                    .findViewById(R.id.friendsImage);
            holder.checkbox = (CheckBox) convertView.findViewById(R.id.check);
            holder.checkbox
                    .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView,
                                boolean isChecked) {
                            Log.d(TAG, "Oncheck clicked");
                            Friend element = (Friend) holder.checkbox
                                    .getTag();
                            element.isSelected = buttonView.isChecked();
                        }
                    });
            holder.checkbox.setTag(mData.get(position));
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
            ((ViewHolder) convertView.getTag()).checkbox.setTag(mData.get(position));

        try {
            Friend curObj = mData.get(position);
            holder.textTitle.setText(curObj.fname);
            holder.checkbox.setChecked(mData.get(position).isSelected);
            //Add image
            convertView.setTag(R.id.tagFriendList, curObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }