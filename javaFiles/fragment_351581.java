private Canvas canvas;
public ColorImage jumpMan;

public JumpMan()
{
    canvas = new Canvas();
    canvas.addMouseListener(this);
    jumpMan = new ColorImage("jumpmanimg.png");
    canvas.add(jumpMan,200,200);
}