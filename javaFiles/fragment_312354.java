public class SharedPreference {

public static final String PREFS_NAME = "PRODUCT_APP";
public static final String FAVORITES = "Product_Favorite";
/*Added*/
private static RecyclerViewClickListener listener;

public RecyclerViewClickListener getListener() {
    return listener;
}

public void setListener(RecyclerViewClickListener listener) {
    SharedPreference.listener = listener;
}

/*Added*/
...
}