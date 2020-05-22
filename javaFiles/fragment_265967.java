TransformGroup tg2 = new TransformGroup ();
               //set the appearance of the product boxes (transparent) 
               Appearance app = new Appearance(); 
               app.setTransparencyAttributes(new TransparencyAttributes(TransparencyAttributes.BLENDED,0.2f));
               //create a box having length = l, breadth = b and height = h
               Box box = new Box( (float )item[p].getLength(), (float) item[p].getBreadth(), (float) item[p].getHeight(), app);

               // vector to translate the item box to the position (x, y, z)
               Vector3f position = new Vector3f((float) x, (float) y, (float) z);
               //creation of a 3D transform group
               Transform3D transform = new Transform3D();
               transform.setTranslation(position);
               tg2.setTransform(transform);
               //add new item box to the transform group
               tg2.addChild(box);
               tg2.setCapability(Group.ALLOW_CHILDREN_EXTEND);
               BranchGroup scene = new BranchGroup();
               scene.addChild(tg2);
               scene1.addChild(scene);