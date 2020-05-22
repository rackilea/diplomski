for (int l = 1; l < pokemon.length; l++) {
        if (pokemon[l][1] != null && pokemon[l][1].contains(a)) {
            resultDex = l;
            break;
        }
    }