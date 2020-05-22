listViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appSelector.selectApp(listStorage.get(position).getName());
                } else {
                    appSelector.removeApp(listStorage.get(position).getName());
                }
            }
        });