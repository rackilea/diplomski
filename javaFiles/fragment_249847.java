FileOutputStream fos;
try {
fos = openFileOutput("Income", Context.MODE_PRIVATE);
DataOutputStream dos = new DataOutputStream(fos);
dos.writeInt(Income);
dos.close();
fos.close();
} catch (IOException e) {
e.printStackTrace();
}