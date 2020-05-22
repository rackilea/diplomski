public static class FragmentConfirmarPicagem extends DialogFragment {
    public  DialogInterface.OnClickListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Confirmar")
                .setMessage("Deseja mesmo picar o ponto agora?")
                .setPositiveButton("Sim", listener)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}