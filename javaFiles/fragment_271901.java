public class OffersDisplayFragment extends Fragment {
    public static final String SHOP_EXTRA = "shopExtra";

    // Creates a new fragment given a Shop
    public static OffersDisplayFragment newInstance(Shop shop) {
        OffersDisplayFragment fragment = new OffersDisplayFragment();
        Bundle args = new Bundle();
        args.putSerializable(SHOP_EXTRA, shop);
        fragment.setArguments(args);
        return fragment;
    }
}