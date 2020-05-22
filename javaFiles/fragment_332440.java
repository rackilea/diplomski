void Nonterminal() : {}
{
    Foo() (<COMMA>  Foo() )*
}

void Foo() : {}
{
    <TOKEN> <COLON> A()
}