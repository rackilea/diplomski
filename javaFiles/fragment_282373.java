InputStream response = connection.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(response));
String responseString = br.readLine();
Integer responseInt = Integer.valueOf(responseString).intValue();
switch(responseInt)
{
  case 1 : //SMS sent
  break;
  case -1 : // Server error
  break;
.
.  // put check conditions similarly
.
}