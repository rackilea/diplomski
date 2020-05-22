//i've encapsulated the sorting code in a method that receives a list as a parameter.
private List<Domain> sortDomains1(final List<Domain> domains)
{
    //this is a tempList that will be returned from subList method.
    List<Domain> tempList = null;
    //as your using iterator anonymously, you have to implement an index
    int i = 0;
    for(final Domain domain : domains) 
    {
        //looking for 'Hilton'.
        if(domain.getName().equalsIgnoreCase("Hilton")) 
        {
            //here we're getting a sublist of 2 elements that need to be switched in positions
            tempList = domains.subList(i, i+2); //have to get 2 elements
            break; //if we'have found it, then we leaven the loop and switch positions;
        }
        //increasing an index of the array
        i++;
    }

    //having a subList we can change the order. It will also change it in the original list.
    Domain tempDomain; //we have to make a switch, so we need a temp Domain.
    tempDomain = tempList.get(1); //the one after hilton will be temp.
    tempList.set(1, tempList.get(0));  //put hilton in second position
    tempList.set(0, tempDomain);       //put temp in first.

    return domains;
}