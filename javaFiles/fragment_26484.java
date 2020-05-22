public Game() {//base constructor
 this.frame = new JFrame();
 Dimension size = new Dimension(width * scale, height * scale);
 setPreferredSize(size);
}

public Game(JFrame jframe)//injected frame constructor
{
 this.frame = jframe;
 Dimension size = new Dimension(width * scale, height * scale);
 setPreferredSize(size);
}