//
// This polygon is wound Clockwise instead of Counter-Clockwise; when you start
//   using projection matrices and face culling this is a concept you will need
//     to understand. 
//
// Counter-Clockwise is the preferred winding order in OpenGL, by the way - I
//   just wanted to show this to you for future reference.
//
glBegin (GL_QUADS);
{
  glTexCoord2f ( 0.0f,  0.0f);
  glVertex2f   (-1.0f, -1.0f); // Bottom-left

  glTexCoord2f ( 0.0f,  1.0f);
  glVertex2f   (-1.0f,  1.0f); // Top-Left

  glTexCoord2f ( 1.0f,  1.0f);
  glVertex2f   ( 1.0f,  1.0f); // Top-Right

  glTexCoord2f ( 1.0f,  0.0f);
  glVertex2f   ( 1.0f, -1.0f); // Bottom-Right
}
glEnd ();