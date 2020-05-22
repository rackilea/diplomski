String[] pokemon= {"Bulbsaur","Squirtle","Weedle","Pidgey","Rattata"};
int len = pokemon.length;
for (int i=0; i < pokemon.length/2; ++i) {
    String temp = pokemon[i];
    pokemon[i] = pokemon[len-1-i];
    pokemon[len-1-i] = temp;
}