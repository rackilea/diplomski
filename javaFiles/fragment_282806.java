public class ResultGpRowAdapter extends ArrayAdapter<RaceResult> {

    Context context;
    int resource;
    List<RaceResult> data=null;

        public ResultGpRowAdapter(Context context, int resource, List<RaceResult> objects)           {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.data = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ........
        }

        //my own method to populate data           
        public void myAddAll(List<RaceResult> items) {

        for (RaceResult item:items){
            super.add(item);
        }
    }