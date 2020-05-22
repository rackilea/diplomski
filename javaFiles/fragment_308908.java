class Rectangle {
  // This should be 'private', but I'm using 'protected' in case I wan to inherit those later, and 'public' to keep things simple
  public float x = 0;
  public float y = 0;
  public float w = 50;
  public float h = 50;
  protected boolean isVisible = true;
  protected color fillColor;

  // This is the constructor. It serves to initialize the class.
  public Rectangle(float xx, float yy, float ww, float hh, color cc) {
    x = xx;
    y = yy;
    w = ww;
    h = hh;
    fillColor = cc;
  }

  public void Render() {
    // I like to let my class draw themselves!
    if (isVisible) {
      fill(fillColor);
      rect(x, y, w, h);
    }
  }

  public void Move(float moveX, float moveY) {
    // This will be used to move. Since the variables are 'protected', they cannot be accessed from outside this class, so I have to create a tool to use them.
    // It is good practice to set 'public' only what's needed, and to manage class variables inside the class.
    // This is for many good reasons. Among those, remember that it's harder to debug 'why is my x position weird' when it can be accessed from anywhere.
    x += moveX;
    y += moveY;
  }

  public boolean Collision(float xx, float yy, float ww, float hh, float moveX, float moveY) {
    // Give coordinates to this function and it will tell you if there's a collision with this rectangle
    return Intersect(x + moveX, y + moveY, w, h, xx, yy, ww, hh);
  }
}