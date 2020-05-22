class CoolDialogFragment extend DialogFragment {

     private Callback callback;


     @Override
      void onAttach(Context context) {
          callback = (Callback) context
      }

      @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_example, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         //find the views in the dialog fragment
         closeBtn.clickListener(...
               callback.updateText(edittext.getText().toString())
               dismiss()
         )
    }
}