private void prepareListFooter() {

    View view = (View) LayoutInflater.from(this).inflate(R.layout.list_footer, null);


    loadMoreButton = (Button) view.findViewById(R.id.load_more_button);
    progressBar = (ProgressBar) view.findViewById(R.id.load_progress);
    listview.addFooterView(view);
    loadMoreButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //downloadMore();
            loadMoreButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
    });
}