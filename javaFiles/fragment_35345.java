boolean displayIdInHex = false;

public void setDisplayIdInDecimal()
{
  displayIdInHex = false;
}

public void setDisplayIdInHex()
{
  displayIdInHex = true;
}

public String toString()
{
  ... stuff ...
  if (displayIdInHex)
  {
    ... output id in hex.
  }
  else
  {
    ... output id in decimal.
  }
}