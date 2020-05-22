if (src >= dest)
    return true;
if (thisPositionAlreadyTested[src])
  return false;
thisPositionAlreadyTested[src] = true;
if ( ...