//......
//......
//......

 if(itemsArrayList.get(position).selFlag){
        holder.radioButton.setChecked(false);
    }
// set listener on radiobutton in adapter like this
    holder.radioButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

        }
    });

    return view;
}