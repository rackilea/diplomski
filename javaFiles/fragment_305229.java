public class MainActivity extends Activity{



    public void prepareViews(int ID, boolean state){
        switch(ID){
        case USERNAME_TEXTBOX:
            LoginUsernameTextBox.setEnabled(state);
            break;
        case PASSWORD_TEXTBOX:
            LoginPasswordTextBox.setEnabled(state);
            break;
        case LOGIN_BUTTON:
            LoginButton.setEnabled(state);
            break;
        case LOGIN_PROGRESSBAR:
            if(state == true){
                LoginProgressBar.setVisibility(View.VISIBLE);
                LoginProgressBar.setIndeterminate(true); }
            else{
                LoginProgressBar.setVisibility(View.GONE);
            }
            break;
        case CONNECTING_DIALOG:
            if(state == true){
                showDialog();
            }
            break;
        }
    }

public void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        ProgressDialogFragment newFragment = new ProgressDialogFragment();
        newFragment.show(fragmentManager, "Dialog");
    }

public static class ProgressDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "", "Connecting to " 
                    + DeviceName.subSequence(0, DeviceName.length() - 17)); 
            return progressDialog;
        }
    }
}