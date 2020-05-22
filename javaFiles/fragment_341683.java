public class WildPokemon{
    ...
    private Random rand = new Random();
    private List<Pokemon> pokemonList;
    ...
    public WildPokemon(){
      pokemonList = new ArrayList();
      Pokemon rattata = new Pokemon("Rattata",randomHealth(15,20),randomAttack(2,5),randomSpeed(2,6));
      pokemonList.add(rattata);
      Pokemon pidgey = new Pokemon("Pidgey",randomHealth(10,17),randomAttack(3,4),randomSpeed(3,5));
      pokemonList.add(pidgey);
      ...
    }

    private Pokemon getRandomPokemon() {
        int n = rand.nextInt(pokemonList.size());
        return pokemonList.get(n);
    }
     ...
}