Process p = Runtime.getRuntime().exec("java my_class_file.class");
/* running compiled code in a separated process */
InputStream in = p.getInputStream();
InputStream err = p.getErrorStream();
OutputStream out = p.getOutputStream();
/* in,err and out streams */