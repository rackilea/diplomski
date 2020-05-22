interface Login {
    void initiateLogin();
}

class LoginFragment extends Fragment implements Login {
    @Override
    public void initiateLogin() {
        // do login
    }
}