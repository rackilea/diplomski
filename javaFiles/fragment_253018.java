private void selectPDFFiles(){
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_GET_CONTENT);
    intent.setType("application/pdf");
    startActivityForResult(intent, 555);
}