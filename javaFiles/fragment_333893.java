public class Tab1 extends Fragment {

LinearLayout linearLayout;
View rootView

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
   rootView = inflater.inflate(R.layout.tab1, container, false);

   return rootView;
}

@Override 
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    linearLayout = (LinearLayout)rootView.findViewById(R.id.linear);

    linearLayout.setOrientation(LinearLayout.VERTICAL);

    TextView textView = new TextView(getActivity());
    textView.setText("example");
    textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT));
    linearLayout.addView(textView);

    ImageView imageView = new ImageView(getActivity());
    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    imageView.setImageResource(R.drawable.placeholder_icon);
    linearLayout.addView(imageView);

    TextView textView2 = new TextView(getActivity());
    textView.setText("example2");
    linearLayout.addView(textView2);
}
}