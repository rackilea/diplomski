public class SettingFragment extends Fragment implements View.OnClickListener {
private TextView mTextTest;
 private TextView mTextTest1;


@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_setting, container, false);
    addControl(view);

    return view;
}



private void addControl(View view) {
    mTextTest = (TextView) view.findViewById(R.id.text_test);
mTextTest1 = (TextView) view.findViewById(R.id.text_test_1);
    mTextTest.setOnClickListener(this);
  mTextTest1.setOnClickListener(this);

}


@Override
public void onClick(View v) {

    FragmentManager manager = getActivity().getSupportFragmentManager();
    switch (v.getId()) {
        case R.id.text_test:
            manager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.content_main, new YourFragment())
                    .commit();
            break;
   case R.id.text_test_1:
  startActivity(new Intent(getActivity(), YourActivity.class))
            break;
        default:
            break;
    }

}