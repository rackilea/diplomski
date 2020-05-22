import android.support.v4.app.Fragment;

public class SimpleFragment extends Fragment {
    private OnFragmentInteractionListener mListener;    // TODO: delete this line

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);

        Button button = (Button)rootView.findViewById(R.id.msg_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: delete these 3 lines, do something else with the button click
                if (mListener != null) {
                    mListener.onFragmentInteraction("Message from Fragment");
                }
            }
        });

        return rootView;
    }

    // TODO: this entire method can be deleted
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    // TODO: this entire method can be deleted
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // TODO: this entire method can be deleted
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String message);
    }
}