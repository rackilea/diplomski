Rule Spaces()
{
    return OneOrMore(AnyOf(" \t"));
}

Rule Letter()
{
    return Range('a', 'z');
}

Rule Word()
{
    return OneOrMore(IgnoreCase(Letter());
}

Rule OneLine()
{
    // EOI == End Of Input
    return Sequence(Optional(Spaces()), Word(),
        ZeroOrMore(Sequence(Spaces(), Word()), EOI);
}