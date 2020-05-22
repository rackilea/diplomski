import java.nio.file.Paths;

CSG union;

void setup(){
  size(900,900,P3D);
  stroke(255);
  //strokeWeight(3);
  // we use cube and sphere as base geometries
  CSG cube = new Cube(2).toCSG();
  CSG sphere = new Sphere(1.25).toCSG();

  // perform union, difference and intersection
  CSG cubePlusSphere = cube.union(sphere);
  CSG cubeMinusSphere = cube.difference(sphere);
  CSG cubeIntersectSphere = cube.intersect(sphere);

  // translate geometries to prevent overlapping 
  union = cube.
          union(sphere.transformed(Transform.unity().translateX(3))).
          union(cubePlusSphere.transformed(Transform.unity().translateX(6))).
          union(cubeMinusSphere.transformed(Transform.unity().translateX(9))).
          union(cubeIntersectSphere.transformed(Transform.unity().translateX(12)));

}

void drawCSG(CSG mesh,float scale){
  beginShape(POINTS);
  for(Polygon p : mesh.getPolygons()){
    for(Vertex v : p.vertices){
      vertex((float)v.pos.getX() * scale,(float)v.pos.getY() * scale,(float)v.pos.getZ() * scale);
    }
  }
  endShape();
}

void draw(){
  background(0);
  translate(width * 0.5, height * 0.5,0);
  rotateY(map(mouseX,0,width,-PI,PI));
  rotateX(map(mouseY,0,height,PI,-PI));

  drawCSG(union,sin(frameCount * 0.01) * 100);
}