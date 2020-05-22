public class InfiniteGalleryAdapter extends BaseAdapter { 
/** The width of each child image */ 
private static final int G_ITEM_WIDTH = 360;   
/** The height of each child image */  
private static final int G_ITEM_HEIGHT = 240; 
/** The context your gallery is running in (usually the activity) */   
private Context mContext;       
private int imageWidth;     
private int imageHeight;   
private int[] imageIds;    
public InfiniteGalleryAdapter(Context c, int[] imageIds) {    
    this.mContext = c;          
    this.imageIds = imageIds; }   
public int getCount() {   
    return Integer.MAX_VALUE;   
}      
public Object getItem(int position) { 
    return position;    }  
public long getItemId(int position) { 
    return position;    }       
//private Activity activity;  
private  LayoutInflater inflater=null;
public InfiniteGalleryAdapter(Context a) {  
    final int[] imageIds;  
    //activity = a;   
    this.mContext = a;   
    inflater = (LayoutInflater)mContext.getSystemService   (        Context.LAYOUT_INFLATER_SERVICE);  
}          public  class ViewHolder{ 
    public TextView text;
    public ImageView image;   
}    

private int[] images = {  
        R.drawable.one_1, R.drawable.one_4,   
        R.drawable.one_2, R.drawable.one_5,   
        R.drawable.one_3               
};    
private String[] name = {   
        "this is my car", "i love this",   
        "please hekp me", "im in park",    
        " This is nice place to visit.",  
};       
public View getView(int position, View convertView, ViewGroup parent) { 
    ImageView i = getImageView(); 
    int itemPos = (position % images.length);  
    try {      

        i.setImageResource(images[itemPos]);  
        ((BitmapDrawable) i.getDrawable()).setAntiAlias(true); } 
    catch (OutOfMemoryError e) {     
        Log.e("InfiniteGalleryResourceAdapter", "Out of memory creating imageview.          Using empty view.", e);  
    }         View vi=convertView;     
    ViewHolder holder;  
    if(convertView==null){ 
        vi = inflater.inflate(R.layout.gallery_items, null);  
        holder=new ViewHolder();      
        holder.text=(TextView)vi.findViewById(R.id.textView1);   
        holder.image=(ImageView)vi.findViewById(R.id.image); 
        vi.setTag(holder);    
    }       else   
        holder=(ViewHolder)vi.getTag();  
    holder.text.setText(name[itemPos]); 
    final int stub_id=images[itemPos];  
    holder.image.setImageResource(stub_id); 
    return vi;     
}   

private ImageView getImageView() { 
    setImageDimensions();   

    ImageView i = new ImageView(mContext);   
    i.setLayoutParams(new Gallery.LayoutParams(imageWidth, imageHeight)); 
    i.setScaleType(ScaleType.CENTER_INSIDE);  
    return i;      }  
private void setImageDimensions() { 
    if (imageWidth == 0 || imageHeight == 0) {        
        imageWidth = AndroidUtils.convertToPix(mContext, G_ITEM_WIDTH);
        imageHeight = AndroidUtils.convertToPix(mContext,G_ITEM_HEIGHT); 
    }         }                  }