Object obj = responseContext.getEntity();
ObjectMapper om = new ObjectMapper();
File file = new File("...");
try {
    OutputStream out = new FileOutputStream(file);
    om.writeValue(out, obj);
} catch (IOException e) {
    // this could fail but you don't want your request to fail
    e.printStackTrace();
}