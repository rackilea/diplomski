protected String getShare() {
  if (this.getClass().getName().equals("com.foo.myclasses.A") or this.getClass().getName().equals("com.foo.myclasses.B")) {
      return share;
  } else
  {
      throw new IllegalAccessException(this.getClass().getName() + " is not allowed to access share);
     // or return null
  }
}