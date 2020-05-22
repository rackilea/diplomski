private void renderCube() {
  textures.get(0).bind();
  glEnableClientState(GL_VERTEX_ARRAY);
  glEnableClientState(GL_TEXTURE_COORD_ARRAY);

  /* These two pointers reference the same memory! */
  glVertexPointer(3, GL_FLOAT, 0, 0);
  glTexCoordPointer(2, GL_FLOAT, 0, 0);

  glDrawArrays(GL_QUADS, 0, 22);
  glDisableClientState(GL_VERTEX_ARRAY);
  glDisableClientState(GL_TEXTURE_COORD_ARRAY);
}