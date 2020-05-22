// the PShape reference which will contain the converted 
PShape csgResult;

void setup(){
  size(900,900,P3D);
  noStroke();
  // JCSG sample code:
    // we use cube and sphere as base geometries
    CSG cube = new Cube(2).toCSG();
    CSG sphere = new Sphere(1.25).toCSG();

    // perform union, difference and intersection
    CSG cubePlusSphere = cube.union(sphere);
    CSG cubeMinusSphere = cube.difference(sphere);
    CSG cubeIntersectSphere = cube.intersect(sphere);

    // translate geometries to prevent overlapping 
    CSG union = cube.
            union(sphere.transformed(Transform.unity().translateX(3))).
            union(cubePlusSphere.transformed(Transform.unity().translateX(6))).
            union(cubeMinusSphere.transformed(Transform.unity().translateX(9))).
            union(cubeIntersectSphere.transformed(Transform.unity().translateX(12)));

    // translate merged geometry back by half the total translation to pivot around centre
    union = union.transformed(Transform.unity().translateX(-6));

  // Convert CSG to PShape -> Note: CSG units are small so we scale them up so the shapes are visible in Processing
  csgResult = CSGToPShape(union,45);
}
// re-usable function to convert a CSG mesh to a Processing PShape
PShape CSGToPShape(CSG mesh,float scale){
  // allocate a PShape group
  PShape csgResult = createShape(GROUP);
  // for each CSG polygon (Note: these can have 3,4 or more vertices)
  for(Polygon p : mesh.getPolygons()){
    // make a child PShape
    PShape polyShape = createShape();
    // begin setting vertices to it
    polyShape.beginShape();
    // for each vertex in the polygon
    for(Vertex v : p.vertices){
      // add each (scaled) polygon vertex 
      polyShape.vertex((float)v.pos.getX() * scale,(float)v.pos.getY() * scale,(float)v.pos.getZ() * scale);
    }
    // finish this polygon
    polyShape.endShape();
    //append the child PShape to the parent
    csgResult.addChild(polyShape);
  }
  return csgResult;
}

void draw(){
  background(0);
  lights();
  translate(width * 0.5, height * 0.5,0);
  rotateY(map(mouseX,0,width,-PI,PI));
  rotateX(map(mouseY,0,height,PI,-PI));
  shape(csgResult);
}