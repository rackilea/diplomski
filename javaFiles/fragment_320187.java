import processing.opengl.*;
import javax.media.opengl.*;

int zSpacing = 10;
PVector[][] slices;

void setup() {
  size(600, 500, OPENGL);

  slices = new PVector[3][3];
  //dummy slice 1
  slices[0][0] = new PVector(400, 200,-200);
  slices[0][1] = new PVector(300, 400,-200);
  slices[0][2] = new PVector(500, 400,-200);
  //dummy slice 2
  slices[1][0] = new PVector(410, 210,-200);
  slices[1][1] = new PVector(310, 410,-200);
  slices[1][2] = new PVector(510, 410,-200);
  //dummy slice 3
  slices[2][0] = new PVector(420, 220,-200);
  slices[2][1] = new PVector(320, 420,-200);
  slices[2][2] = new PVector(520, 420,-200);
}

void draw() {
  background(255);

  PGraphicsOpenGL pgl = (PGraphicsOpenGL) g;  // g may change
  GL gl = pgl.beginGL();  // always use the GL object returned by beginGL

  for(int i = 0 ; i < slices.length; i ++){
    gl.glColor3f(0, .15 * i, 0);
    gl.glBegin(GL.GL_POLYGON);
    for(int j = 0; j < slices[i].length; j++){
      gl.glVertex3f(slices[i][j].x, slices[i][j].y,slices[i][j].z + (zSpacing * i));
    }
    gl.glEnd();
  }
  pgl.endGL();
}