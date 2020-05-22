public class State {

     private Town capital;
     private Set<Town> towns;

     public State() {
       this.towns = new HashSet();
     }

     public State(Town capital) {
       this.capital = captial;
       this.towns = newHashSet();
       this.towns.add(capital)
     }


     public void setCapital(Town capital) {
       this.captial = capital;
     }

     public Town getCapital() {
       return this.capital;
     }

     public void addTown(Town town) {
       this.towns.add(town)
     }

     public Set getTowns() {
       return this.towns;
     }
}