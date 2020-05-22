if(convertView == null)
{
    convertView = mInflater.inflate(R.layout.ringtone_bit, null);
    holder = new ViewHolder();
    convertView.setTag(holder);
    holder.play        = ( ImageView ) convertView.findViewById(R.id.play);
    holder.download    = ( ImageView ) convertView.findViewById(R.id.download);
    holder.ratebutton  = ( ImageView ) convertView.findViewById(R.id.ratebutton);
    holder.rtitle      = (TextView)  convertView.findViewById(R.id.rtitle);
    holder.size        = (TextView)  convertView.findViewById(R.id.size);
    holder.downloads   = (TextView)  convertView.findViewById(R.id.downloads);
    holder.voters      = (TextView)  convertView.findViewById(R.id.voters);
    holder.personname   = (TextView)  convertView.findViewById(R.id.personname);
    holder.date         = (TextView)  convertView.findViewById(R.id.date);
    holder.ratingsmall = (RatingBar) convertView.findViewById(R.id.ratingsmall);
} else {
    holder = (ViewHolder) convertView.getTag();
}

// Fill the data