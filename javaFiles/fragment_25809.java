public class MovieAdapter extends BaseAdapter
{
    private final Context context;
    private List<CurrentMovie> movieData;
    private static LayoutInflater inflater=null;

    public MovieAdapter(Context context, List<CurrentMovie> movieData)
     {
         this.context = context;
         this.movieData = movieData;
         inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     } 

     @Override
     public int getCount() {
         return movieData.size();
     }

     @Override
     public Object getItem(int position) {
         return movieData.get(position);
     }

     @Override
     public long getItemId(int position) {
         return position;
     }


     public static class ViewHolder{              
         public TextView movieTitle;
         public ImageView movieImage;

     }

     public View getView(int position, View convertView, ViewGroup parent) 
     {

         View vi = convertView;
         ViewHolder holder;

         if(convertView==null){
             vi = inflater.inflate(R.layout.tabitem, null);

             holder = new ViewHolder();
             holder.movieTitle = (TextView) vi.findViewById(R.id.title);
             holder.movieImage=(ImageView)vi.findViewById(R.id.image);

             vi.setTag( holder );
         }
         else 
             holder=(ViewHolder)vi.getTag();



              holder.movieTitle.setText(movieData.get(position).getTitle());


         return vi;
     }
 }