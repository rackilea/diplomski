Image picture;
Ellipse2D base, bT, snare, lT, rT, hh, lC, rC;

public void init()
{
    picture = getImage(getDocumentBase(),"drumSet.jpg");

    base  = new Ellipse2D.Double(355, 415, 305, 240); //Bass
    bT    = new Ellipse2D.Double (715, 360, 325, 245); //Bottom Tom
    snare = new Ellipse2D.Double ( 35, 410, 290, 200); //Snare
    lT    = new Ellipse2D.Double (283, 130, 185, 165); //Left Tom
    rT    = new Ellipse2D.Double (543, 120, 200, 175); //Right Tom
    hh    = new Ellipse2D.Double (  0, 225, 250, 150); //High Hat
    lC    = new Ellipse2D.Double ( 10,   0, 305, 195); //Left Cymbal
    rC    = new Ellipse2D.Double (765,   0, 505, 275); //Right Cymbal
}