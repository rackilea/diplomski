Intent sendIntent = new Intent(Intent.ACTION_SEND);
sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"youremail@gmail.com"});  
sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
sendIntent.putExtra(Intent.EXTRA_STREAM,tvFechaSi.getText());
sendIntent.setType("text/html");
startActivity(sendIntent);