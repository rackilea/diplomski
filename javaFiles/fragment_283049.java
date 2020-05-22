@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    ViewHolder viewHolder;
    if(view == null){
        view = layoutInflater.inflate(R.layout.list_item_video, viewGroup, false);
        viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
    }else{
        viewHolder = view.getTag();
    }
    VideoObject item = getVideoObjectItem(i);
    viewHolder.duration.setText(item.getFormattedDuration());
    viewHolder.title.setText(item.getName());
    if(item.getThumbnail() != null){
        viewHolder.thumbnail.setImageBitmap(item.getThumbnail());
    }
    return view;
}