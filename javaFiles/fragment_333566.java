InputStreamReader inputStream = new InputStreamReader
  (getResources().openRawResource(R.raw.randomstuff));
BufferedReader br = new BufferedReader(inputStream);
int numLines = 30;
Random r = new Random();
int desiredLine = r.nextInt(numLines);

String theLine="";
int lineCtr = 0;
while ((theLine = br.readLine()) != null)   {
  if (lineCtr == desiredLine) {
    break;
  }
  lineCtr++;
 }
...
Log.d(TAG, "Magic line is: " +theLine);