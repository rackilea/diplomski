public class FragmentTab2 extends SherlockFragment {

    private String[]names = {"Video", "Audio"};
    private String[]urls = {"http://c172200.r0.cf3.rackcdn.com/104824.mp4", "http://c172200.r0.cf3.rackcdn.com/106973.mp4"};

    @Override
    public View onCreateView(LayoutInflater inflater1, ViewGroup container,
            Bundle savedInstanceState) {
        // Get the view from fragmenttab2.xml
        View view = inflater1.inflate(R.layout.fragmenttab2, container, false);

        ListView lv = (ListView) view.findViewById(R.id.List);
        VideoAdapter adapter = new VideoAdapter(this, names, urls);
        lv.setAdapter(adapter);

        return view;
    }
}