ByteArrayOutputStream baos = new ByteArrayOutputStream();
org.apache.commons.io.IOUtils.copy(in, baos);
byte[] bytes = baos.toByteArray();

// either
while (needToReadAgain) {
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    yourReadMethodHere(bais);
}

// or
ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
while (needToReadAgain) {
    bais.reset();
    yourReadMethodHere(bais);
}