int ternarySearch(MyFunctor f, int left, int right, float absolutePrecision) {
  #left and right are the current bounds; the maximum is between them
  if (right - left) < absolutePrecision:
    return (left + right)/2

  leftThird = (2*left + right)/3
  rightThird = (left + 2*right)/3

  if (f.myFunction(leftThird) < f.myFunction(rightThird)) {
    return ternarySearch(f, leftThird, right, absolutePrecision)
  }
  return ternarySearch(f, left, rightThird, absolutePrecision)
}