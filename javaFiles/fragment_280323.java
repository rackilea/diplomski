@Override
protected void finalize() throws Throwable {
    // TODO Auto-generated method stub
    System.out.println("finalize: " + myName);
    super.finalize();
}