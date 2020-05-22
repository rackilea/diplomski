public class Multiselection extends DialogFragment {

final CharSequence[] items={"easy","medium","hard"};
String selection;
@Override
@NonNull
public Dialog onCreateDialog(Bundle savedInstanceState)
{
final String [] items = getResources().getStringArray(R.array.my_drinks_selection); //gets array items to screen
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle("Choose drink").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        selection = items[which];
    }
}