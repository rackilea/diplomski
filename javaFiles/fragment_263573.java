public test(int pMagic, String pStr)
{
  this.magic = pMagic; //int magic = pMagic was a new variable only in the constructor scope
  this.str = pStr;
  calcBonus();
 }