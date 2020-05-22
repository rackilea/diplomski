@Override
public Dialog onCreateDialog(Bundle savedInstance)
{
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();
    View root = layoutInflater.inflate(R.layout.dialog_create, null);

    builder.setView(root).setMessage(R.string.create);
    // ...

    Button createDateBtn = (Button) root.findViewById(R.id.create_date_button);
    // set click listener here ...

    return builder.create();
 }