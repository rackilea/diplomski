public interface LoginMVP {
    interface View {
        void showLoadingIndicator(boolean active);
        void loginSuccess();
        void loginFailured(String message);
    }
    interface Presenter {
        void validateFields(String email, String password);
        void loginServerCallback();
    }

    interface OnLoginCallBack{
        void onSuccess();
        void onError();
    }
    interface Model {
        void loginServer(String email, String password);
    }
}