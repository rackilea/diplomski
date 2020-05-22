try (ByteArrayOutputStream os = new ByteArrayOutputStream();){
    byte[] buffer = new byte[6];
    os.write("poulet".getBytes("UTF-8"));
    try(ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());){
        is.read(buffer, 0, 6);
        System.out.println("Read result:|" + (new String(buffer, "UTF-8") + "|"));
    }
} catch (IOException e) {
}