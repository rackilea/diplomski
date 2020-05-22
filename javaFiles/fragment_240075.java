Complex eval(Complex z, Complex coeff[]) {
  Complex eval = 0;

  for (int i = coeff.length-1; i > 0; i--) {
    eval += Complex.add(coeff[i], Complex.mul(eval, z));
  }

  return eval + coeff[0];
}