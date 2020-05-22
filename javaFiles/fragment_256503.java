String res = "";
String url = "http://www.domain.com/youscript.php";
URL urlObj = new URL(url);
URLConnection lu = urlObj.openConnection();


// Send data - if you don't need to send data 
// ignore this section and just move on to the next one
String data = URLEncoder.encode("yourdata", "UTF-8");
lu.setDoOutput(true);
OutputStreamWriter wr = new OutputStreamWriter(lu.getOutputStream());
wr.write(data);
wr.flush();

// Get the response
BufferedReader rd = new BufferedReader(new InputStreamReader(lu.getInputStream()));
String line = "", res = "";
while ((line = rd.readLine()) != null) {
  res += line;
}

wr.flush();
wr.close();
System.out.println(res);