final String checkage = age.getText().toString();
int value = Integer.parseInt(checkage);

if(value >= 4 && value <= 80) {
      Toast.makeText(this, "You must be older than 4 and younger than 80", Toast.LENGTH_SHORT).show();
      return;
}