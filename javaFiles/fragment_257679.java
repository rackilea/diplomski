// myParty is an instance of Party; I assume you have some sort of accessor to 
// the partyList
LinkedList<Guy> partyList = myParty.getPartyList();
ListIterator<Guy> it = partyList.listIterator();
while( it.hasNext() ) {
    Guy g = it.next();
    partyScreen.add(new JLabel( g.getName() ));
    partyScreen.add(new JSeparator() );
}