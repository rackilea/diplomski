if (Keyboard.isKeyDown(Keyboard.KEY_F1)) {
       GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
       glDisable(GL_TEXTURE_2D);
}

if (Keyboard.isKeyDown(Keyboard.KEY_F2)) {
       GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
       glEnable(GL_TEXTURE_2D)
}