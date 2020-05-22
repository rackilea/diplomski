public class FancyFragment extends Fragment {
  @BindView(R.id.rate) TextView textViewToChange;  //it is automatically cast to TextView
  @BindView(R.id.button) Button button;  //or a button

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fancy_fragment, container, false);
    ButterKnife.bind(this, view);  //do not forget this!
    // TODO Use fields...
    return view;
  }
}