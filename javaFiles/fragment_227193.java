import java.nio.file.Paths;

PShape csgResult;

void setup(){
  size(900,900,P3D);
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

  // save union as stl
  try {
      FileUtil.write(
              Paths.get(sketchPath("sample.obj")),
              union.toObjString()
      );
  } catch (IOException ex) {
      ex.printStackTrace();
  }

  //load shape into Processing
  csgResult = loadShape(sketchPath("sample.obj"));

}

void draw(){
  background(0);
  translate(width * 0.5, height * 0.5,0);
  scale(sin(frameCount * 0.1) * 100);
  if(csgResult != null){
    shape(csgResult);
  }
}