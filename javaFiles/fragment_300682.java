void id() #ID :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}

void expr() #EXPR :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}