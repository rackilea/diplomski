holder.packageId.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mTextClickListener.onTextClick(view,position,PackagesList);
            holder.packageId.setTypeface(null, Typeface.BOLD);
            model.setTapped(true);
            for (int i = 0; i < MyList.size(); i++) {
                ReturnPackageModel model1= PackagesList.get(i);
                if(position != i){
                    model.setTapped(false);
                    notifyDatasetChanged()
                }
            }
        }
    });