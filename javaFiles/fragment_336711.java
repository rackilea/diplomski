public void addAfterPokeball(Pokemon theOneToInsertAfter, Pokemon pok) {
           Pokeball newPokeball = new Pokeball(pok);
           Pokeball tmp = head;
           while (tmp != null && tmp.pok.name != theOneToInsertAfter.name) {
               tmp = tmp.next;
           }
           if (tmp!=null){
              newPokeball.next = tmp.next;
              tmp.next = newPokeball;
           } else {
             //could not find the pokeball to insert after
           }
        }