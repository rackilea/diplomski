void var_decl() #VAR :
{}
{
  <VAR> id() <COL> id() <EQ> expr() <SCOL>
}

void id() #ID :
{}
{
  <ID>
}

void expr() #EXPR :
{}
{
  <ID>
}