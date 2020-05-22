public class GridAdapter extends BaseAdapter {
   private Context mContext;

   // Constructor
   public GridAdapter (Context c) {
      mContext = c;
   }

   public int getCount() {
      return alphabets.length;
   }

   public Object getItem(int position) {
      return null;
   }

   public long getItemId(int position) {
      return 0;
   }

   // create a new TextView for each item referenced by the Adapter
   public View getView(final int position, View convertView, ViewGroup parent) {
      TextView txView;

      if (convertView == null) {
         txView= new TextView (mContext);
         txView.setLayoutParams(new GridView.LayoutParams(85, 85));
         txView.setPadding(8, 8, 8, 8);
      } 
      else 
      {
         txView= (TextView) convertView;
      }
      txView.setText(alphabets[position]);

       **Update**
       txView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            //your code here
               switch(position){
                case 0:
                    Toast.makeText(this,"A",Toast.LENGTH_LONG).show();
                break;
                case 1:
                    Toast.makeText(this,"B",Toast.LENGTH_LONG).show();
                break;
                ........SoOn
               }

           }});


      return txView;
   }

   //  array
   public String[] alphabets= {
      "A","B","C","D"
   };
}