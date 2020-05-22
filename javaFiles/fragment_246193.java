if(c!=0) {
            c--;
            updateLabel(pokemons[c]);
        } else if(c==0) {
            c = rollover-1; // <-- here
            updateLabel(pokemons[c]);
        }