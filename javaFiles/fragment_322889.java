Iterator HoldingsTableRows = HoldingsTableRows.iterator();

//This if statement prevents an exception from being thrown
//because of an invalid call to .next()
if (HoldingsTableRows.hasNext())
    HoldingsTableRows.next();

while (HoldingsTableRows.hasNext())
{
    //...somecodehere...
}