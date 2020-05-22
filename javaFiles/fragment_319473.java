public int pokemon(String input) {
    pokemon = data.load();
    String a = input.trim();//trim to remove trailing \r from input
    if("exist".equals(a)) {
        System.exit(0);
    }

    for (int l = 1; l < pokemon.length; l++) {
        if (pokemon[l][1] != null && pokemon[l][1].contains(a)) {
            resultDex = l;
            break;//End the loop
        }
    }
    return resultDex;
}