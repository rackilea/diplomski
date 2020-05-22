public class YourCursorAdapter extends CursorAdapter {
      public YourCursorAdapter(Context context, Cursor cursor, int flags) {
          super(context, cursor, 0);
      }

      // The newView method is used to inflate a new view and return it, 
      // you don't bind any data to the view at this point. 
      @Override
      public View newView(Context context, Cursor cursor, ViewGroup parent) {
          return LayoutInflater.from(context).inflate(R.layout.your_item_view, parent, false);
      }

      // The bindView method is used to bind all data to a given view
      // such as setting the text on a TextView. 
      @Override
      public void bindView(View view, Context context, Cursor c) {
          // Find fields to populate in inflated template
          TextView tvproduct = (TextView) view.findViewById(R.id.tcproduct);
          TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
          TextView tvType = (TextView) view.findViewById(R.id.tvType);
          // Extract properties from cursor
          String row_PRODUCT = c.getString(c.getColumnIndex(KEY_PRODUCT));
        String row_PRICE = c.getString(c.getColumnIndex(KEY_PRICE));
        String row_TYPE = c.getString(c.getColumnIndex(KEY_TYPE));

          // Populate fields with extracted properties
          tvproduct.setText(row_PRODUCT);
           tvPrice.setText(row_PRICE);
           tvType.setText(row_TYPE);

      }
    }