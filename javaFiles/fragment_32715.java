@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.overview_list_item_fragment, container, false);
  mOverViewHeading = (TextView) view.findViewById(R.id.frag_overview_heading_textview);
  return view;
}