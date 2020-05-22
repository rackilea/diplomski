public class DSelectIcon extends DialogFragment{

    private View v = null;

    private ImageView Selection;
    private static final Integer[] items = { R.drawable.image1,
            R.drawable.image1, R.drawable.image1,
            R.drawable.image1, R.drawable.image1,
            R.drawable.image1, R.drawable.image1,
            R.drawable.image1 };



    public DSelectIcon() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Restore last state for checked position.
        }
        LayoutInflater inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.grid_icon_event, null);
        return createDSelectIcon(v);
    }

    private AlertDialog createDSelectIcon(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Selection = v.findViewById(R.id.selection);
        GridView grid = v.findViewById(R.id.grid);
        // grid.setAdapter(new ArrayAdapter<Integer>(this, R.layout.cell,
        // items));
        grid.setAdapter(new CustomGridAdapter((MainActivity)getActivity(), items));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Clicked postion is" + i,
                        Toast.LENGTH_LONG).show();
                //Selection.setImageResource(items[arg2]);
            }
        });

        builder.setView(v);


        return builder.create();
    }

    public class CustomGridAdapter extends BaseAdapter {
        private Activity mContext;

        // Keep all Images in array
        public Integer[] mThumbIds;

        // Constructor
        public CustomGridAdapter(MainActivity mainActivity, Integer[] items) {
            this.mContext = mainActivity;
            this.mThumbIds = items;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
            return imageView;
        }

    }
}