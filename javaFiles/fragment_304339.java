import com.actionbarsherlock.R;
import com.actionbarsherlock.app.SherlockFragment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends SherlockFragment {

    Button loginButton;
    Button registerButton;
    Polling activity;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loginfragment, container, false);

        return v;
    }

    public void onResume() {
        super.onResume();
        Log.d("Econ", "onresume");

        loginButton = (Button) getActivity().findViewById(R.id.loginButton);
        loginButton.setOnClickListener(loginListener);
        registerButton = (Button) getActivity().findViewById(R.id.registerButton);
        registerButton.setOnClickListener(registerListener);

    }

    public OnClickListener loginListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            if(loginButton.getText().toString() == "Log Out") {

                activity.loginReport(2);
                loginButton.setText(R.string.login);
                //Remove user from dB sqllite when I know how
            }
            else {
            Log.v("LoginF", "onclick");
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Logging in...");
            LoginTask loginTask = new LoginTask((Polling) getActivity(), progressDialog);
            loginTask.execute();
            }
        }
    };


    public OnClickListener registerListener = new OnClickListener() {
        @Override
        public void onClick(View v) {


            Log.v("Register", "onclick");
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Registering new user...");
            RegisterTask registerTask = new RegisterTask((Polling) getActivity(), progressDialog);
            registerTask.execute();
            }

    };

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (Polling) activity;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
        Log.d("Econ", "onstart");
    }


    public void onPause() {
        super.onPause();Log.d("Econ", "onpause");
    }

    public void onStop() {
        super.onStop();
        Log.d("Econ", "onstop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Econ", "ondestroyview");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("Econ", "ondestroy");

    }

    public void onDetach() {
        super.onDetach();
        Log.d("Econ", "ondetach");
    }

}