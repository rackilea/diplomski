sendemail(Vector<String> addr, String subject, String body) {
  ..
}

sendemail(String addr, String subject, String body) {
  Vector<String> vaddr = new Vector<String>();
  vaddr.add(addr);
  sendemail(vaddr, subject, body);
}