@GET
@Path("/helloWorldZip") 
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public StreamingOutput helloWorldZip() throws Exception {
    return new StreamingOutput(){
    @Override
        public void write(OutputStream arg0) throws IOException, WebApplicationException {
            // TODO Auto-generated method stub
            BufferedOutputStream bus = new BufferedOutputStream(arg0);
            try {
                //ByteArrayInputStream reader = (ByteArrayInputStream) Thread.currentThread().getContextClassLoader().getResourceAsStream();     
                //byte[] input = new byte[2048];  
                java.net.URL uri = Thread.currentThread().getContextClassLoader().getResource("");
                File file = new File("D:\\Test1.zip");
                FileInputStream fizip = new FileInputStream(file);
                byte[] buffer2 = IOUtils.toByteArray(fizip);
                bus.write(buffer2);
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }
    };
}