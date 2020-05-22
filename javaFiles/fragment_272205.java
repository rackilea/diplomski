Person()
{
    this.name = "lary";
    this.unitedStates = new Address();
    this.unitedKingdom = new Address();
}

Person(String n)
{
    this.name = n;
    this.unitedStates = new Address("myStreet", "myCountry");
    this.unitedKingdom = new Address();
}