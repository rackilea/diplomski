float y_angle = 0;

while (!Display.isCloseRequested()) {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    GL11.glLoadIdentity();
    GL11.glRectd(0, 0, 0.2f, 0.3f);
    GL11.glTranslatef(0, 0, 0);

    while (Keyboard.next()){
        if (Keyboard.getEventKey() == Keyboard.KEY_A) {
            y_angle += 10f;
        }
    }

    GL11.glRotatef(y_angle, 0, 0, 1);

    Display.update();
    Display.sync(60);
}