private Intent getIntentForString(String textViewContents){
  if(textViewContents.equals(getString(R.string.info_about))){
    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] { 
      AboutActivity.this.getString(R.string.feedback_email) } );
    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, 
      AboutActivity.this.getString(R.string.feedback_subject)); 
    emailIntent.setType("plain/text"); 
    return emailIntent;
  }
  else if(textViewContents.equals(getString(R.string.info_terms)){
    return new Intent(InfoActivity.this, TermsActivity.class);
  }
  else if(textViewContents.equals(getString(R.string.info_privacy)){
    return new Intent(InfoActivity.this, Privacy.class);
  }
  else{
    return null;
  }
}