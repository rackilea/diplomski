if(QAText.getText().toString().equals(getString(R.string.fc_front))){
   QAText.setText(R.string.fc_back);
   Toast.makeText(getApplicationContext(), R.string.fc_front , Toast.LENGTH_LONG).show();
}else{
   QAText.setText(R.string.fc_front);
   Toast.makeText(getApplicationContext(), "SWAPPING: back-to-front", Toast.LENGTH_LONG).show();
}