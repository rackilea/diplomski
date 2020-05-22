public void onClick(View v) {
    switch (v.getId()) {
    case R.id.button1 : 
        try {   
            Intent intent = new Intent(this, PdfReader.class /*the name changed*/);
            intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, "R.drawable.untitled");
            startActivity(intent); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}