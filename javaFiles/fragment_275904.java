public class AlertFragment extends DialogFragment{

public static AlertFragment newInstance(){
    return new AlertFragment(); }

public AlertFragment(){}



@Override 
public Dialog onCreateDialog(Bundle SaveInstanceState){

    return new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), android.R.style.Theme_Dialog)).setMessage("Alert Dialog").setPositiveButton("Set", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getContext(), "Positive", Toast.LENGTH_SHORT).show();
        }
    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getContext(), "Negative", Toast.LENGTH_SHORT).show();
        }
    }).create(); 
} 

}