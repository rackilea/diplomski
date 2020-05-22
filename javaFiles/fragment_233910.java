String camera = String.valueOf (request.getAttribute("webcamfile"));
File f = new File(itemx.getName());
if (camera != null && !camera.isEmpty()) {
    f=new File(camera);
}
System.out.println(f);