FileInputStream planeStream;
...
planeStream = files.getIni("plane.ini");
ini.load(planeStream);
...
for( int i=0; i<planes.length; i++ ){
    planes[i] = new plane(planeStream);
}