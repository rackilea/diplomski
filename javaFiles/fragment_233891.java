public class Square{
    public int pcolor;
    public int contains;
    public int xPos;
    public int yPos;
    Square(int xp,int yp,int pc,int cont){
        xPos=xp;
        yPos=yp;
        contains=cont;
        pcolor=pc;
    }
    Square[] board = new Square[64];
}