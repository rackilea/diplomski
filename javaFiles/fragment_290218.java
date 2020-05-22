@Test
public void signInAndShowProgress() {
    signInPresenter.onSignInClicked("", "");

    verify(mSignInView, times(0)).showErrorMessage(Mockito.any(String.class));

    verify(mSignInView).showLoading();

}