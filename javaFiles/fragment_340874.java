int compareTo(Quaternion o){
  // return (int)(this.norm() - o.norm());
  double tNorm = this.norm;
  double oNorm = o.norm;
  int retVal = 0;

  if (tNorm < oNorm){
    retVal = -1;
  } else if (tNorm > oNorm){
    retVal = 1;
  }

  return retVal;
}