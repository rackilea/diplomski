private View inflateRequires(View view){
            if (view == null){
                view = inflater.inflate(R.layout.view_beacon_info,null,false);
                view.setTag(new ViewHolder(view));
            }
            return view;
        }