@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
  final FragmentActivity c = getActivity();
  View layout = inflater.inflate(R.layout.fragment_feed, container, false);
  mBlogList = (RecyclerView) layout.findViewById(R.id.blog_list);
  return layout;
}