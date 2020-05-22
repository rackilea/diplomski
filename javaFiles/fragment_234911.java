int index = ... //some value you received in broadcast
int progress = ...//some value you received in broadcast

View view = listView.getChildAt(index);
if (view != null) {
    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    if (progressBar != null) {
        progressBar.setProgress(progress);
    }
}