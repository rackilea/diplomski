public class Adapter<T> extends ArrayAdapter<T> {

    private int viewResourceId;
    private LayoutInflater inflater;
    private ArrayList<T> list;

    public Adapter(Context context, int viewResourceId, ArrayList<T> list) {
        super(context, viewResourceId, list);
        this.viewResourceId = viewResourceId;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        Holder holder;

        if (arg1 == null || arg1.getTag() == null) {
            holder = new Holder();

            arg1 = inflater.inflate(viewResourceId, null);
            arg1.setTag(holder);

            holder.textView = (TextView) arg1.findViewById(R.id.txtUse);
        } else {
            holder = (Holder) arg1.getTag();
        }

        // A,B,C
        if(list.get(arg0)  instanceof A){
            //User A's property to set TextView text
        } else if(list.get(arg0) instanceof B){
            //User B's property to set TextView text
        } else if(list.get(arg0) instanceof C){
            //User C's property to set TextView text
        }

        return arg1;
    }

    static class Holder {
        TextView textView;
    }
}