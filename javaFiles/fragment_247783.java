public class SchulfachDialog extends DialogFragment {

    private EditText editTextName;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View view = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_schulfach, null);

        builder.setView(view)
                .setTitle("Add new subject")
                .setMessage("Message")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editTextName.getText().toString();
                        SchulfachDialogListener listener = (SchulfachDialogListener) getTargetFragment();
                        listener.applyTexts(name);
                    }
                });
        editTextName = view.findViewById(R.id.edit_name);

        return builder.create();
    }
}