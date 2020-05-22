public void init() {

   Terrain ter = new Terrain();   // create object of class Terrain
   Figure fig = new Figure();     // create object of class Figure

   ter.setFigure(fig);
   fig.setTerrain(ter);

}