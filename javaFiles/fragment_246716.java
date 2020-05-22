final ViewHolder holder = null;

if (convertView == null) {

    holder = new ViewHolder();
    convertView = inflater.inflate(R.layout.customlayout, null);
    holder.llContainer = (RelativeLayout) convertView.findViewById(R.id.llContainer);
    holder.titleOfDream = (TextView) convertView.findViewById(R.id.titleTextView);
    holder.descriptionOfDream = (TextView) convertView.findViewById(R.id.descriptionTextView);
    convertView.setTag(holder);
} else {
    holder = (ViewHolder) convertView.getTag();
}
holder.titleOfDream.setText(mDisplayedValues.get(position).getTitleOfDream());
holder.descriptionOfDream.setText(mDisplayedValues.get(position).getDescriptionOfDream() + "");

return convertView;