public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
        holder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.second_layout, parent, false);
        holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name1);
        holder.tv_contact = (TextView) convertView.findViewById(R.id.tv_phoneno);
        holder.tv_email=(TextView)convertView.findViewById(R.id.tv_email);
        holder.tv_dob=(TextView)convertView.findViewById(R.id.tv_dob);
        holder.tv_qualification=(TextView)convertView.findViewById(R.id.tv_qualification);
        holder.tv_time=(TextView)convertView.findViewById(R.id.tv_time);

        //bind holder.btn_update and holder.btn_delete here

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.tv_name.setText(mPersonList.get(position).getName());
    holder.tv_contact.setText(mPersonList.get(position).getContactno());
    holder.tv_email.setText(mPersonList.get(position).getEmail());
    holder.tv_dob.setText(mPersonList.get(position).getDatepicker());
    holder.tv_qualification.setText(mPersonList.get(position).getQualification());
    holder.tv_time.setText(mPersonList.get(position).getTimepicker());

    holder.btn_update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Call your dialog to update and pass "mPersonList.get(position)" model so that data in the model will be updated.
            //Once update is done call refreshList() from the confirmation dialog button.
        }
    });

    holder.btn_delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPersonList.remove(position);
            refreshList();
        }
    });

    return convertView;

}

private void refreshList() {
    notifyDataSetChanged();
}