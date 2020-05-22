//Polygon mesh
//AffineTransform at

int[] x = mesh.xpoints;
int[] y = mesh.ypoints;
int[] rx = new int[x.length];
int[] ry = new int[y.length];

for(int i=0; i<mesh.npoints; i++){
  Point2d p = new Point2d.Double(x[i], y[i]);
  at.transform(p,p);
  rx[i]=p.x;
  ry[i]=p.y;
}

mesh = new Polygon(rx, ry, mesh.npoints)