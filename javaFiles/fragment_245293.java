boolean excluded1 = buttons.chkExcludedA1 &&
    isBetween(content[i].getNwdMean(), buttons.getDir1A(), buttons.getDir1B()));
boolean excluded2 = buttons.chkExcludedA2 &&
    isBetween(content[i].getNwdMean(), buttons.getDir2A(), buttons.getDir2B()));
boolean excluded3 = buttons.chkExcludedA3 &&
    isBetween(content[i].getNwdMean(), buttons.getDir3A(), buttons.getDir3B()));
boolean excluded4 = buttons.chkExcludedA4 &&
    isBetween(content[i].getNwdMean(), buttons.getDir4A(), buttons.getDir4B()));

boolean excluded = (excluded1 || excluded2 || excluded3 || excluded4);