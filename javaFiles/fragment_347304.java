Intent feedbackEmail = new Intent(Intent.ACTION_SEND);

feedbackEmail.setType("text/email");
feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"yourfeedbackreceiveemailid"});
feedbackEmail.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));