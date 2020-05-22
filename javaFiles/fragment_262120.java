Now Your Fragment

public class HowTo extends Fragment {

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {

            View android = inflater.inflate(R.layout.how_to, container, false);
            ((TextView) android.findViewById(R.id.howTo)).setText("howto");

ViewPager viewPager = (ViewPager) MainActivity.mInstance.findViewById(R.id.pager);

int nextFragment = viewPager.getCurrentItem() + 1;

                Button next_frag = (Button) android.findViewById(R.id.next_frag);
                next_frag.setOnClickListener(new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(View v) {
                        // Swipe to page`?

viewPager.setCurrentItem(nextFragment);

                    }
                });
            return android;

        }
}