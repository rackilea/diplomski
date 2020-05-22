String toString(JLabel jl) {
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  XMLEncoder e = new XMLEncoder(baos);
  e.writeObject(jl);
  e.close();
  return new String(baos.toByteArray());
}

JLabel fromString(String str) {
    XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(str.getBytes()));
    JLabel label = (JLabel) d.readObject();
    d.close();
    return label;
}