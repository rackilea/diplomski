public class SpinnerAdapter<T> extends ArrayAdapter<T> {

    private Context context;
    private ArrayList<T> values;
    private Typeface fontLight;
    private int color, layoutId, textViewId;
    //private int fontSize;

    private boolean IsSingleLine;
    private boolean IsFirstPositionSelectable, setTextSizeLimit = true;

    public SpinnerAdapter(Context context, int resource, int textViewResourceId,
        ArrayList<T> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.values = objects;
        this.layoutId = resource;
        this.textViewId = textViewResourceId;
    }

    public SpinnerAdapter(Context context, int resource, ArrayList<T> objects, int color,
        boolean isSingleLine) {
        super(context, resource, objects);

        this.context = context;
        this.values = objects;
        this.color = color;
        this.IsSingleLine = isSingleLine;
    }

    @Override public int getCount() {
        return values.size();
    }

    @Override public T getItem(int position) {
        return values.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public boolean isFirstPositionSelectable() {
        return IsFirstPositionSelectable;
    }

    public void setFirstPositionSelectable(boolean enable) {
        IsFirstPositionSelectable = enable;
    }

    public void setSetTextSizeLimit(boolean setTextSizeLimit) {
        this.setTextSizeLimit = setTextSizeLimit;
    }

    public Typeface getFontLight() {
        return fontLight;
    }

    public void setFontLight(Typeface fontLight) {
        this.fontLight = fontLight;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);

            if (layoutId == 0) {
                convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
            } else {
                convertView = inflater.inflate(layoutId, parent, false);
            }
        }

        TextView label;

        if (textViewId == 0) {
            label = (TextView) convertView.findViewById(android.R.id.text1);
        } else {
            label = (TextView) convertView.findViewById(textViewId);
        }

        if (setTextSizeLimit) {
            label.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2) });
        }

        label.setSingleLine(IsSingleLine);
        label.setPaddingRelative(25, 15, 25, 15);

        if (fontLight != null)
            label.setTypeface(getFontLight());

        label.setText(values.toArray(new Object[values.size()])[position].toString());

        return label;
    }

    @Override public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);

            if (layoutId == 0) {
                convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
            } else {
                convertView = inflater.inflate(layoutId, parent, false);
            }
        }

        TextView label;

        if (textViewId == 0) {
            label = (TextView) convertView.findViewById(android.R.id.text1);
        } else {
            label = (TextView) convertView.findViewById(textViewId);
        }


        //label.setPadding(30, 10, 10, 30);
        //label.setTextSize(context.getResources().getDimension(R.dimen.text_size_small));
        if (fontLight != null)
            label.setTypeface(fontLight);

        label.setSingleLine(IsSingleLine);

        label.setText(values.toArray(new Object[values.size()])[position].toString());

        return label;
    }
}