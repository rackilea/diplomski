protected void onPostExecute(File file) {
    super.onPostExecute(file);

    Context context = contextWeakReference.get();


    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(
            Uri.fromFile(file),
            "application/pdf");

    context.startActivity(intent);

}