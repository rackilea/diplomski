// enable wireframe
glPolygonMode( GL_FRONT, GL_LINE );

// draw stuff to be wireframe'd
DrawStuff();

// restore regular rendering
glPolygonMode( GL_FRONT, GL_FILL );