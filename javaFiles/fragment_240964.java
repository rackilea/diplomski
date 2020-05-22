TransformGroup obj = new TransformGroup();
Scene s = null;
ObjectFile f = new ObjectFile ();
f.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
try{ s = f.load (obj_path+model+"\\"+model+".obj"); }catch(Exception ex) { ex.printStackTrace(); }
obj.addChild(s.getSceneGroup());
obj.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);