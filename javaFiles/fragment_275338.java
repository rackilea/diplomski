function mo(a) {
  a = a.split("");
  a = lo.rw(a, 1);
  a = lo.rw(a, 32);
  a = lo.IC(a, 1);
  a = lo.wS(a, 77);
  a = lo.IC(a, 3);
  a = lo.wS(a, 77);
  a = lo.IC(a, 3);
  a = lo.wS(a, 44);
  return a.join("")
}