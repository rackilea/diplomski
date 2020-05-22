public class StringProgressDialogFragment extends DialogFragment {
    private String message;

    public static StringProgressDialogFragment newInstance(String message) {
        StringProgressDialogFragment dialog = new StringProgressDialogFragment();
        Bundle args = new Bundle();
        args.putString("message", message);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        message = getArguments().getString("message");
        dialog.setMessage(message);
        return dialog;
    }
}