class A implements Dated {
 int id;
 Date date;

 @Override
 public Date getDate() {
    return date;
 }
}

class B implements Dated {
  int id;
  Date date;

  @Override
  public Date getDate() {
    return date;
  }
}