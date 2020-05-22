InputStream is = getAssets().open("patient.txt");
int size = is.available();
byte[] buffer = new byte[size];
is.read(buffer);
is.close();
String json = new String(buffer, "UTF-8");
JSONArray ja = new JSONArray(json);
System.out.println("LENGTH IS____"+ ja.length());
String[][] table = new String[ja.length()][4];