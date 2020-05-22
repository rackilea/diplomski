public void addPokemon(Pokemon pok) {
        if (this.head != null) {
            if(pok.getLevel()<this.head.pok.getLevel()){
                Pokeball newPokeball = new Pokeball(pok);
                newPokeball.next = this.head;
                this.head = newPokeball;
                return;
            }
            this.head.addPokemon(this.head, pok);
        } else {
            this.head = new Pokeball(pok);
        }
    }