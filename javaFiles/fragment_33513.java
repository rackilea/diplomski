int effective_len(Complex coeff[]) {
  int pos = 0;
  Complex zero();

  for (int i=0; i<coeff.lengh; i++) {
    if (!zero.equals(coeff[i])) {
      pos = i;
    }
  }

  return pos + 1;
}