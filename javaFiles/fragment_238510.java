private Bundle savedState = null;

 @Override
    public void onDestroyView() {
        super.onDestroyView();
        savedState = saveState();
    }

    private Bundle saveState() { /* called either from onDestroyView() or onSaveInstanceState() */
        Bundle state = new Bundle();
        state.putCharSequence("TEXT_HELLO_WORD", helloWordTextView.getText());
        return state;
    }

 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* (...) */

        if(savedInstanceState != null && savedState == null) {
            savedState = savedInstanceState.getBundle("FRAGMENT_HELLO_WORD");
        }
        if(savedState != null) {
         helloWordTextView.setText(savedState.getCharSequence("TEXT_HELLO_WORD"));
        }
        savedState = null;

        /* (...) */
        return view;
    }
...
@Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    //Save the fragment's state here somehow like this
    outState.putBundle("FRAGMENT_HELLO_WORD", (savedState != null) ? savedState : saveState());
}