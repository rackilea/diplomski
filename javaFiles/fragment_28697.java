imgCamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, ScanAdaptor.class);
        ((Activity) context).startActivity(intent);
    }
}