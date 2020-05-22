public class OffersDisplayFragment extends Fragment {
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       // Get back arguments
       Shop = (Shop) getArguments().getSerializable(SHOP_EXTRA);

       // Do something with the Shop here   
   }
}