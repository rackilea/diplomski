public void init() {

   Terrain ter = new Terrain();   // create object of class Terrain
   Figure fig = new Figure(ter);  // create object of class Figure in the terrain

   // no setters needed, since figure constructor sets up
   // the relationship.

}