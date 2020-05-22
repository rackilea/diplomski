try
{
 Intent intentUrl = new Intent(Intent.ACTION_VIEW);
 intentUrl.setDataAndType(url, "application/pdf");
 intentUrl.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 myActivity.startActivity(intentUrl);
}
catch (ActivityNotFoundException e)
{
 Toast.makeText(myActivity, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
}