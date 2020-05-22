public class MyAlert extends DialogFragment implements OnClickListener {

private EditText getEditText;
MainActivity callBackActivity;
CustomDialogInterface customDI;

public MyAlert(CustomDialogInterface customDI)
{
    this.customDI = customDI;
}

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {

    callBackActivity = new MainActivity();
    getEditText = new EditText(getActivity());
    getEditText.setInputType(InputType.TYPE_CLASS_TEXT);
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("Get UserName :");
    builder.setMessage("Enter Your Name :");
    builder.setPositiveButton("Ok", this);
    builder.setNegativeButton("Cancel", null);
    builder.setView(getEditText);
    return builder.create();
}

@Override
public void onClick(DialogInterface dialog, int which) {
    String value = getEditText.getText().toString();
    Log.d("Name : ", value);
    dialog.dismiss();
    customDI.okButtonClicked(value);


}
}