public class MyFragment extends android.support.v4.Fragment {

    // Part of your class

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //Part of your code

        // add text views
        tv1 = new TextView(getActivity());
        tv1.setText(getString(R.string.blue));
        tv1.setTextColor(Color.WHITE);

        tv2 = new TextView(getActivity());
        tv2.setText(getString(R.string.green));
        tv2.setTextColor(Color.WHITE);

        tv3 = new TextView(getActivity());
        tv3.setText(getString(R.string.orange));
        tv3.setTextColor(Color.WHITE);

        // Rest of your code
    }

    // Rest of your class
}