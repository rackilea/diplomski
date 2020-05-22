btSet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    ProgressBar progress = ((LinearLayout) v.getParent())
                        .findViewById(R.id.progressBar);
    OnDownloadStarted(0, progress);

    }
});