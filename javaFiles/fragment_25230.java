Token parseConstant() :
{
    Token t;    
}

{
    (
      t = < INTEGER > | t = < FLOAT_NUMBER > | t = < BOOLEAN >
    )
    {
      return t;
    }

}