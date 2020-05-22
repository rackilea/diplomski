Configuration conf = new Configuration();
   ByteArrayOutputStream downloadedFile = downloadFile();
   //convert outputstream in inputstream
   InputStream is=Functions.FROM_BAOS_TO_IS.apply(fileOutputStream);
   String myfile="miofile.csv";
   //acquiring the filesystem
   FileSystem fs = FileSystem.get(URI.create(dest),conf);
   //openoutputstream to hadoop
   OutputStream outf = fs.create( new Path(dest));
   //write file 
   IOUtils.copyBytes(tmpIS, outf, 4096, true);
   //commit the read task
   Dataset<Row> ds = session
    .read()
    .option("header", "true") 
    .csv(myfile)