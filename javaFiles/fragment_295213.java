URL url = new URL("http://localhost:9090/xcvbb/rest/integrationservices/getPDF");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setRequestProperty("Accept", "application/pdf");

if (conn.getResponseCode() != 200) {
throw new RuntimeException("Failed : HTTP error code : "
        + conn.getResponseCode());
}

InputStream is = conn.getInputStream();

//writing the downloaded data into the file we created
FileOutputStream fileOutput = new FileOutputStream("C:/Users/dkimigho/Downloads/bitarraypdf.pdf");

/* use binary I/O to prevent line based operation messing with the encoding.*/
byte[] buf = new byte[2048];
int b_read = 0;
while ( (b_read = is.read(buf)) > 0) {
    fileOutput.write(buf, 0, b_read);
}
fileOutput.flush();
//closed the output stream
fileOutput.close();
//
conn.disconnect();

} catch (MalformedURLException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}