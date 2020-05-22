public class DrawPlanes extends JComponent{
    public DrawPlanes(int centreX,int centreY, int radius, Color colour)
    {
      this.centreX = centreX;
      this.centreY = centreY; 
      this.radius = radius;
      this.colour = colour;
    }

    @Override
    public Dimension getPreferredSize() {

         return new Dimenstion(width, height);
                               // ^ provide your required size 
    }

}