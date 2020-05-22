class Complex {
  public static Complex mul(Complex c0, Complex c1) {
    double r0=c.getRe(), r1=c1.getRe();
    double i0=c.getIm(), i1=c1.getIm();
    return new Complex(r0*r1-i0*i1, r0*i1+r1*i0);
  }

  public static Complex mulStore(Complex res, Complex c0, Complex c1) {
    double r0=c.getRe(), r1=c1.getRe();
    double i0=c.getIm(), i1=c1.getIm();
    if(res==null) {
      res=new Complex();
    }
    res.setRe(r0*r1-i0*i1);
    res.setIm(r0*i1+r1*i0);
    return res;
  }

  // equiv with this *= rhs;
  public void mulAssign(Complex rhs) {
    // perform the "this * rhs" multiplication and 
    // store the result in this. 
    Complex.mulStore(this, rhs, this);
  } 

}