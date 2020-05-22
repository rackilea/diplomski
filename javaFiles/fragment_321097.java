if (convertView == null)
{
    convertView = LayoutInflater.from(mContext).inflate(R.layout.card_item, null);
    holder = new ViewHolder();

    holder.CardContent = (TextView) convertView.findViewById(R.id.cardText);

    // Add this line
    convertView.setTag(holder);
}