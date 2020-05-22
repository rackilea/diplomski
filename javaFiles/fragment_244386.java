if (convertView == null) {
    convertView = lInflater.inflate(R.layout.item, parent, false);
}

Product p = getProduct(position);

progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

Button btSet = (Button) view.findViewById(R.id.btSet);

mProductDownloaderMap.put(position, progressBar);

btSet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OnDownloadStarted(position);// position is indicated taskID

    }
});