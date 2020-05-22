View v = convertView;
Object o = data.get(position);
LayoutInflaer inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

if(o != null){
    if(o instanceof ImageMessage){
        if(v == null){
            v = inflater.inflate(R.layout.image_message);
        }
        createImageMessagView(v, (ImageMessage) o);
    } else if (o instanceOf textMessage){
        // handle different object type
    }