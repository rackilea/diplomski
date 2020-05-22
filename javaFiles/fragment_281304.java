public class YourFragment extends Fragment {

public static final String COLOR_PARAM = "param1";

private String currentColor;

public YourFragment() {}


public static Fragment newInstance(String param) {
    Fragment fragment = new Fragment();
    Bundle args = new Bundle();
    args.putString(COLOR_PARAM, param);
    fragment.setArguments(args);
    return fragment;
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        currentColor = getArguments().getString(COLOR_PARAM);
    }

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.your_fragment_layout, container, false);
    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fragment_layout);
    if (currentColor.equals("green")) {
        frameLayout.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_green_dark));
    }
    else if (currentColor.equals("red")) {
        frameLayout.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_red_dark));
    }

    return view;
}
}