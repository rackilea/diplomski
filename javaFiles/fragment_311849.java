public class CarListAdapter extends BaseAdapter {
    private Activity activity;
    private Fragment fragment;
    private LayoutInflater layoutInflater;
    private List<Car> carItems;

    public CarListAdapter(Fragment fragment, List<Car> carItems, Activity activity) {
        this.fragment = fragment;
        this.carItems = carItems;
        this.activity = activity;
    }
.....