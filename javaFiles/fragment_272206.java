Person(String n, Address unitedStates, Address unitedKingdom)
{
    this.name = n;
    this.unitedStates = unitedStates;
    this.unitedKingdom = unitedKingdom;
}

Person(String n)
{
    this(n, new Address("myStreet", "myCountry"), new Address());
}

Person()
{
    this("lary", new Address(), new Address());
}