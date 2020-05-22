@Override
    public void onBindViewHolder(MySettingHolder holder, int position) {
        // Setting for one entry
        Settings setting = settingList.get(position);

        holder.settingImage.setImageResource(setting.getSettingImageUrl());
        // If the settingSubtitle is empty it should be not visible and just the settingTitle
        if (setting.getSettingSubtitle().equals("")) {
            holder.settingTitle.setText(setting.getSettingTitle());
            holder.settingSubtitle.setVisibility(View.GONE);
        } else {
            holder.settingTitle.setText(setting.getSettingTitle());
            holder.settingSubtitle.setText(setting.getSettingSubtitle());
        }

        holder.type = setting.getType();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySettingHolder holder = (MySettingHolder )(v.getTag());
                switch (holder.type) {

                    case 1:                        
                        // do logout
                        break;

                    case 2:                        
                        // do other stuff
                        break;

                    default:
                        break;
                }
            }
        });

        // set viewholder
        holder.itemView.setTag(holder);
    }