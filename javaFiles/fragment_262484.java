InputStream input = new FileInputStream(file); 
ByteArrayOutputStream output = new ByteArrayOutputStream();
byte[] buffer = new byte[8192];

for (int length = 0; (length = input.read(buffer)) > 0;) {
    output.write(buffer, 0, length);
}

byte[] bytes = output.toByteArray(); // Pass that instead to RMI response.