class ProgressBarFragment {
    //...
    static void setVisibility(Activity parent, int visible) {
           ProgressBarFragment progressBar =
                   (ProgressBarFragment)parent.getSupportFragmentManager()
                   .findFragmentById(R.id.fragment_progress_bar);
    progressBar.setProgressBar(visible);
    //...
}