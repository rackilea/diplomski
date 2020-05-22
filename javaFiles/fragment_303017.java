public class MainViewFragment extends Fragment {
    private MessageSender mMessageSenderCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
         try {
            mMessageSenderCallback = (MessageSender) context;
        } catch (ClassCastException e) {
            // Error, class doesn't implement the interface
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // Remove activity reference
        mMessageSenderCallback = null;
    }
}