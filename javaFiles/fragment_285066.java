@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View rowView = convertView;
    holder = new ViewHolder();
    if(convertView == null) {
        rowView = inflater.inflate(R.layout.view_of_list, parent, false);
        holder.tv_name = (TextView) rowView.findViewById(R.id.tv_name);
        holder.tv_phone = (TextView) rowView.findViewById(R.id.tv_phone);
        holder.img_profile = (ImageView) rowView.findViewById(R.id.img_profile)
        rowView.setTag(holder);
    }else{
        holder = (ViewHolder) rowView.getTag();
    }
    contact = (Mycontact)mycontacts.get(position);
    holder.tv_name.setText(contact.getName());
    holder.tv_phone.setText(contact.getPhone());
    holder.img_profile.setImageResource(contact.getId());
    return rowView;
}