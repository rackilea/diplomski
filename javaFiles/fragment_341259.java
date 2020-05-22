public class FilesAndFoldersAdapter extends ArrayAdapter<String> {
    public FilesAndFoldersAdapter(Context context, ArrayList<String> values) {
       super(context, 0, values);
    } 

    @Override 
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position 
       String filePath = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view 
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylist, parent, false);
       } 

       // Lookup view for data population 
       TextView tvName = (TextView) convertView.findViewById(R.id.Itemname);
       ImageView ivImage = (ImageView) convertView.findViewById(R.id.icon);

       // Populate the data into the template view using the data object 
       tvName.setText(filePath);

       if (new File(filePath).isDirectory()) {
           ivImage.setImageResouce(R.drawable.folder_icon);
       } else {
           ivImage.setImageResouce(R.drawable.file_icon);
       }

       // Return the completed view to render on screen 
       return convertView;
   } 
}