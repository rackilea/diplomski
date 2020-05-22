@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHodler holder = null;

    if(convertView == null){
        holder = new ViewHodler();
        convertView = songInf.inflate(R.layout.song_list_item, parent, false);
        holder.songView = (TextView)convertView.findViewById(R.id.titleListTextView);
        holder.artistView = (TextView)convertView.findViewById(R.id.artistListTextView);
        holder.albumView = (RoundedImageView)convertView.findViewById(R.id.albumListImageView);
        holder.relativeLayout   = (RelativeLayout)convertView.findViewById(R.id.layoutSelector);
        convertView.setTag(holder);
    }else{
        holder =(ViewHodler) convertView.getTag();
    }

    //get song using position
    Song currSong = songs.get(position);

    //get title and artist strings
    holder.albumView.setImageBitmap( getAlbumart(currSong, parent.getContext()) ); // replace getAlbumart() with the new way you are using
    holder.songView.setText(currSong.getTitle());
    holder.artistView.setText(currSong.getArtist());

    holder.relativeLayout.setTag( currSong.getID());

    return convertView;
}

class ViewHodler{
    TextView songView;
    TextView artistView;
    RelativeLayout relativeLayout;
    RoundedImageView albumView;
}