@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    final String[] array = {"male","felmale","unknow","guess"};
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setIcon(R.drawable.ic_star);
    builder.setTitle("Choose your sex")
            .setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sex = array[i];
                    //handle on click 
                }
            });

    return builder.create();
}