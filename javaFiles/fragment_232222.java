@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode == 10 && resultCode == RESULT_OK){
        Uri contactUri = data.getData();
        Intent contactIntent = new Intent(Intent.ACTION_CALL);
        contactIntent.setData(contactUri);
        startActivity(contactIntent);
    }

    if(requestCode == 20 && resultCode == RESULT_OK){
        Uri audioUri = data.getData();
        Intent audioIntent = new Intent(Intent.ACTION_VIEW);
        audioIntent.setDataAndType(audioUri,"audio/*");
        startActivity(audioIntent);
    }

    if(requestCode == 30 && resultCode == RESULT_OK){
        Uri videoUri = data.getData();
        Intent videoIntent = new Intent(Intent.ACTION_VIEW);
        videoIntent.setDataAndType(videoUri,"video/*");
        startActivity(videoIntent);
    }

    if(requestCode == 40 && resultCode == RESULT_OK){
        Uri pdfUri = data.getData();
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(pdfUri,"pdf/*");
        startActivity(pdfIntent);
    }

}