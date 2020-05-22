HttpEntity entity = response.getEntity();
if (entity != null) {
    String name = response.getFirstHeader('Content-Disposition').getValue();
    String fileName = disposition.replaceFirst("(?i)^.*filename=\"([^\"]+)\".*$", "$1");
    FileOutputStream fos = new FileOutputStream("C:\\" + fileName);
    entity.writeTo(fos);
    fos.close();
}