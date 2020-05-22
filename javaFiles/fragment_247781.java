public class MainFragment extends Fragment implements SchulfachDialogListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnShowAlertDialog = view.findViewById(R.id.button_show_alert_dialog);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchulfachDialog dialog = new SchulfachDialog();
                dialog.setTargetFragment(MainFragment.this, 0);
                dialog.show(requireActivity().getSupportFragmentManager(), null);
            }
        });

        return view;
    }

    @Override
    public void applyTexts(String text) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show();
    }
}