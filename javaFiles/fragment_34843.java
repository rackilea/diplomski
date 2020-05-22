//download
public void downloadFile(String download_path, String dest_file_path) {
    try {
        URL u = new URL(download_path);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        InputStream stream = conn.getInputStream();

        File f = new File(dest_file_path);
        FileOutputStream fos = new FileOutputStream(f);
        int bytesRead = 0;
        byte[] buffer = new byte[4096];
        while ((bytesRead = stream.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();
        stream.close();
        hideProgressIndicator();
    } catch(FileNotFoundException e) {
        hideProgressIndicator();
        return; 
    } catch (IOException e) {
        hideProgressIndicator();
        return; 
    }
}