Vector3f toScreenVector = new Vector3f(0, 0, 1);

Transform3D t3d = new Transform3D();
canvas.getImagePlateToVworld(t3d);
t3d.transform(toScreenVector);

tg.getTransform(t3d); //tg is Transform Group of all objects in a scene
t3d.transform(toScreenVector);