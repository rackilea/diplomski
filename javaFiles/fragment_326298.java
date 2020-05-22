holder.pickedPlayer.setOnCheckedChangeListener(null);
        //define private boolean selected with setter and getter
        holder.pickedPlayer.setChecked(playerData.isSelected());
        holder.pickedPlayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
            playerData.setSelected(isChecked);
            if (isChecked)
            {
               Toast.makeText(context,"checked", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context,"not checked", Toast.LENGTH_LONG).show();
            }
            }
        });