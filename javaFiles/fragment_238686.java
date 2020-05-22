class MyData{
   String someText;
   String someText2;
   String buttonText;
}

List<MyData> list = new ArrayList<MyData>();

public class MyAdapter extends BaseAdapter{

   public MyAdapter(Context c, List<MyData> list){
   }


   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
       // inflate your custom list item layout and put your data
   }
}