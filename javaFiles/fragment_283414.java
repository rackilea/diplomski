public class MyAdapter extends BaseAdapter 
{
    Context ctx;
    ArrayList<Person> plist;
    LayoutInflater linf;
    public PersonHolder ph=null;
    private ArrayList<Integer> selected=new ArrayList<Integer>();


    public MyAdapter(Context ctx, ArrayList<Person> plist) {
        super();
        this.ctx = ctx;
        this.plist = plist;
    }

    public class PersonHolder
    {
        public TextView age;
        public TextView name;
        public CheckBox check;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return plist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return plist.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup arg2) {
        // TODO Auto-generated method stub

        linf=(LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            convertView=linf.inflate(R.layout.row_item, null);
            ph=new PersonHolder();
            ph.age=(TextView) convertView.findViewById(R.id.text1);
            ph.name=(TextView) convertView.findViewById(R.id.text2);
            ph.check=(CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(ph);
        }
        else
        {
            ph=(PersonHolder) convertView.getTag();
        }

        Person p=(Person) getItem(position);
        ph.age.setText(p.getAge());
        ph.name.setText(p.getName());
        ph.check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                // TODO Auto-generated method stub
//              if(ph.check.isChecked())
//              {
                    ph.check.setSelected(arg1);
                    if(arg1){ 
                        selected.add(position);
                    }else{
                        selected.remove(position);
                    }
//              }
//              else
//              {
//                  ph.check.setSelected(false);
//              }
            }
        });
        return convertView;
    }
 public ArrayList<Integer> getSelected(){
     return selected;
}
}