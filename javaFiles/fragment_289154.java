//Write to the sdcard in folder Documents:
out = new BufferedWriter(new FileWriter(new File(new File(Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS), filename));

//Write the header:
out.write(".PCD v.7 - Point Cloud Data file format\n" +
          "VERSION .7\n" +
          "FIELDS x y z\n" +
          "SIZE 4 4 4\n" +  //you only have 3 values xyz
          "TYPE F F F\n" +
          "COUNT 1 1 1\n" +
          "WIDTH "+ xyzIj.xyzCount "\n" +
          "HEIGHT 1\n" +
          "VIEWPOINT 0 0 0 1 0 0 0\n" +
          "POINTS " + xyzIj.xyzCount + "\n"
          "DATA ascii \n");

//Write the point cloud points by iterating over the XYZij buffer:
for (int i=0; i<=xyzIj.xyz.length-3; i+=3) {
  out.write(String.valueOf(xyzIj.xyz[i]) + " "); // separate the float values
  out.write(String.valueOf(xyzIj.xyz[i+1]) + " ");
  out.write(String.valueOf(xyzIj.xyz[i+2]) + "\n");
}

out.close();