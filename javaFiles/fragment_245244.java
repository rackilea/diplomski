public double maxAngle() {
  if(getAngleA() => getAngleB() && getAngleA() => getAngleC())
    return getAngleA();
  if(getAngleB() => getAngleA() && getAngleB() => getAngleC())
    return getAngleB();
  return getAngleC();
}