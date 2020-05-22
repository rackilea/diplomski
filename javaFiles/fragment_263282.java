public class SimpleAdapterWithCheckbox extends SimpleAdapter {


public SimpleAdapterWithCheckbox(Context context,
        List<? extends Map<String, ?>> data, int resource, String[] from,
        int[] to) {
    super(context, data, resource, from, to);

}

 // method getView start for each row in adapter to show it in ListView
 public View getView(int position, View convertView, ViewGroup parent) {                
        View v = super.getView(position, convertView, parent);
        startChrono(v);// starting for each row
        return v;       
    }


 private void  startChrono(View v){

    //Here we need to know structure of layout to get our element 
    LinearLayout vwParentRow = (LinearLayout)v;
    LinearLayout ChildTop = (LinearLayout) vwParentRow.getChildAt(0);
    LinearLayout ChildTop2 = (LinearLayout) ChildTop.getChildAt(1);

    //Now, we get chronometer and could work with it as we wont
    Chronometer chrono = (Chronometer) ChildTop2.getChildAt(0);
    chrono.setBase(SystemClock.elapsedRealtime());
    chrono.start();

 }