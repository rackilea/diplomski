glMatrixMode(GL_MODELVIEW);
glLoadIdentity();
glTranslatef(100.0, 50.0, 0.0);
glRotatef(-25.0, 0.0, 1.0, 0.0);  

glGetFloatv(GL_MODELVIEW_MATRIX , *your_matrix*);
//print your matrix to check if that is the desired transformation coordinates