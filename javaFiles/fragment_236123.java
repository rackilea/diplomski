public void setImageSelected(int colorID){
Intent resultIntent = new Intent();
resultIntent.putExtra("SELECTED_COLOR", colorID);
setResult(Activity.RESULT_OK, resultIntent);
finish();
}