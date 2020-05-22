//Here you'll need to create some boolean array or list to store
//checked not checked positions lets call it checked
boolean[] checkedArr = new boolean[catalogDatabases.size()];
// catalogDatabases.size represents your data set size
// note that all items will be false initially

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        /**
         * Other views binding.......
         */
        holder.itemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                checkedArr[position] = isChecked;
                sumAllCheckedAndNotify();
            }
        }
        );
    }