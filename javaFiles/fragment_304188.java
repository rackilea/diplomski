GraphicsEnvironment ge = GraphicsEnvironment.
getLocalGraphicsEnvironment();
GraphicsDevice[] gs = ge.getScreenDevices();
for (int j = 0; j < gs.length; j++) { 
   GraphicsDevice gd = gs[j];
   System.out.println("ID#: " + gd.getDeviceID());
}