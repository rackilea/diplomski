@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    pdfView = view.findViewById(R.id.pdfView); 
    pdfView.fromAsset("tenor-madness.pdf").load();
}