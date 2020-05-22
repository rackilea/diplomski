public void addPokemon(Pokeball current, Pokemon pok) {
     // if next is null add it to next
     if (current.next == null){
         current.next = new Pokeball(pok); 
     }
    // if next is not null and value is between two sequences add it between
    else if( pok.getLevel() > current.pok.getLevel() && pok.getLevel()<= 
    current.next.pok.getLevel()) {
       Pokeball newPokeball =  new Pokeball(pok);  
       newPokeball.next = current.next;
       current.next = newPokeball;
    } 
  // If value is not between call recursion again
   else {
      addPokemon(current.next, pok);
   }