public class IconDialog extends DialogFragment {

    @LayoutRes
    protected int layoutRes = R.layout.icd_dialog_icon;

    Dialog onCreateDialog(final Bundle state) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") final View view = inflater.inflate(layoutRes, null);
}

public class InputIconDialog extends IconDialog {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutRes = R.layout.icd_dialog_icon;
    }