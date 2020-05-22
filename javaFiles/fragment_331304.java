public class example {

private String loc;

class custom_row_adapter extends ArrayAdapter<Integer> {
    custom_row_adapter(Context context, int picId, String url) {
        super(context, R.layout.activity_custom_row_adapter, picId);
        loc = url;
    }
  }
}