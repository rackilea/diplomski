public class IndexPageActivity extends Activity implements OnItemClickListener{ 
ListView listView;
EditText editTextB;
PagesAdapter adapter1;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
            listView = (ListView) findViewById(R.id.pageList);
            editTextB = (EditText) findViewById(R.id.searchB);
            adapter1 = new PagesAdapter(this);
            listView.setAdapter(adapter1);
            adapter1.notifyDataSetChanged();
            listView.setOnItemClickListener(this);

            editTextB.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence cs, int arg1, int arg2,
                        int arg3) {
                    // When user changed the Text
                    IndexPageActivity.this.adapter1.getFilter().filter(cs.toString());
                    adapter1.notifyDataSetChanged();
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1,
                        int arg2, int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                }
            });
    }


@Override
public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
    // TODO Auto-generated method stub
    Intent i;
    String name = adapter1.getItem(position);
            Log.d("id", name);
    if (name.equals("Item1"))
    {
        i = new Intent(this, anActivity.class);
        startActivity(i);
    }
    else if (name.equals("Item2"))
    {
        i = new Intent(this, anActivity2.class);
        startActivity(i);
    }
}
}


class SingleRow {
String pagedata;
SingleRow(String pagedata){
    this.pagedata=pagedata;
}
}
class PagesAdapter extends BaseAdapter implements Filterable{
ArrayList<String> pagelist;
List<String> arrayList;
Context context;
String [] pagedatas;

PagesAdapter(Context c){
    context=c;
    pagelist = new ArrayList<String>();
    Resources res = c.getResources();
    pagedatas = res.getStringArray(R.array.pages_data);
    for (int i=0;i<463;i++){
        pagelist.add(pagedatas[i]);
    }
}
@Override
public int getCount() {
    // TODO Auto-generated method stub
    return pagelist.size();
}

@Override
public String getItem(int i) {
    // TODO Auto-generated method stub
    return pagelist.get(i);
}

@Override
public long getItemId(int i) {
    // TODO Auto-generated method stub
    return i;
}


@Override
public View getView(int i, View view, ViewGroup viewG) {
    // TODO Auto-generated method stub
    LayoutInflater inflater=(LayoutInflater)             context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row=inflater.inflate(R.layout.single_row,viewG,false);
    TextView pagetitle = (TextView) row.findViewById(R.id.textViewRow);

    String temp=pagelist.get(i);

    pagetitle.setText(temp);
    return row;
}

public class filter_here extends Filter{

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        // TODO Auto-generated method stub

        FilterResults Result = new FilterResults();
        // if constraint is empty return the original names
        if(constraint.length() == 0 ){
            Result.values = pagelist;
            Result.count = pagelist.size();
            return Result;
        }

        ArrayList<String> Filtered_Names = new ArrayList<String>();
        String filterString = constraint.toString().toLowerCase();
        String filterableString;

        for(int i = 0; i<pagelist.size(); i++){
            filterableString = pagelist.get(i);
            if(filterableString.toLowerCase().contains(filterString)){
                Filtered_Names.add(filterableString);
            }
        }
        Result.values = Filtered_Names;
        Result.count = Filtered_Names.size();

        return Result;
    }

    @Override
    protected void publishResults(CharSequence constraint,FilterResults results) {
        // TODO Auto-generated method stub
        pagelist = (ArrayList<String>) results.values;
        notifyDataSetChanged();
    }

}

@Override
public Filter getFilter() {
    // TODO Auto-generated method stub

    return new filter_here();
}
}