public class Trainer {

        public final String name;
        private Pokeball head;

        ...

        public void prepend(Pokemon pok) {
           Pokeball newPokeball = new Pokeball(pok);
           newPokeball.next = this.head;
           this.head = newPokeball;
        }
    }