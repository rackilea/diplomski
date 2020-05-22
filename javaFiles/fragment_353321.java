int count = 0;
    while(!Display.isCloseRequested()) {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

      count++;
      if(count < 100)
        glTranslatef(0, 0, speed);
      else
      {
        glTranslatef(0, 0, -100*speed); // To initial position
        count = 0;
      }

      glBegin(GL_POINTS);
      for(Point p : points) {
        glVertex3f(p.x, p.y, p.z);
      }

      glTranslatef(0, 0, screenWidth);

      glBegin(GL_POINTS);
      for(Point p : points) {
        glVertex3f(p.x, p.y, p.z);
      }

      glEnd();

      System.out.println("" + speed);

      Display.update();

      Display.sync(60);
    }