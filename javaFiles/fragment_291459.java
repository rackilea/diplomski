public boolean after(Date when) {
    return getTime() > when.getTime();
}

public boolean before(Date when) {
  return getTime() < when.getTime();
}

...

public long getTime() {
    return (long) jsdate.getTime();
}