try {
FileInputStream fis;
fis = openFileInput("Income");
DataInputStream dis = new DataInputStream(fis);
TOTAL_INCOME = dis.readInt();
dis.close();
fis.close();
} catch (IOException e) {
e.printStackTrace();
}
TextView textView = (TextView) findViewById(R.id.IncomeValue);
textView.setText(""+ TOTAL_INCOME);