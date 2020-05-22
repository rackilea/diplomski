public void doLogin(String userName, String password) {
    view.showLoadingIndicator(true);
    modal.loginServer(userName, password, new LoginMVP.OnLoginCallBack() {
        @Override
        public void onSuccess() {
            view.showLoadingIndicator(false);
            view.loginSuccess();
        }

        @Override
        public void onError() {
            view.showLoadingIndicator(false);
            view.loginFailured("SomeError");
        }
    });
}