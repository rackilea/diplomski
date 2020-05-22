String fileNameNew= java.net.URLEncoder.encode(fileName);
if (fileNameNew == null || fileNameNew.equals("")) return null;

Object obj = null;
ObjectInputStream input = null;
...