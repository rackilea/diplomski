boolean excluded =
  (buttons.chkExcludedA1 &&
   isBetween(content[i].getNwdMean(), buttons.getDir1A(), buttons.getDir1B())) ||
  (buttons.chkExcludedA2 &&
   isBetween(content[i].getNwdMean(), buttons.getDir2A(), buttons.getDir2B())) ||
  (buttons.chkExcludedA3 &&
   isBetween(content[i].getNwdMean(), buttons.getDir3A(), buttons.getDir3B())) ||
  (buttons.chkExcludedA4 &&
   isBetween(content[i].getNwdMean(), buttons.getDir4A(), buttons.getDir4B()));