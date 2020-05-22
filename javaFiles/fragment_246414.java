public class ArticleFragment extends Fragment {

    private static final String ARG_PARAM_TITLE = "title";
    private static final String ARG_PARAM = "content";

    private String title;
    private String content;

    /**
     * Static factory method that takes a String parameter,
     * initializes the fragment's arguments, and returns the
     * new fragment to the client.
     */
    public static ArticleFragment newInstance(String title, String content) {
        ArticleFragment f = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_TITLE, title);
        args.putString(ARG_PARAM, content);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM_TITLE);
            content = getArguments().getString(ARG_PARAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.articlefragmentviewer, container, false);

        getActivity().setTitle(title);
        TextView tvArticle = (TextView) view.findViewById(R.id.tv_article);
        tvArticle.setText(content);
        return view;
    }
}