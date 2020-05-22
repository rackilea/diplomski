public class Figure {

    Terrain ter

    // constructor requires an instance of Terrain, 
    // since the figure must always be placed in a terrain
    public Figure(Terrain ter) {

       this.ter = ter;

       // let terrain know this is the main figure.
       ter.setFigure(this);          
    }

}