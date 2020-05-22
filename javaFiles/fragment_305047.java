private void getAnchors(DataSnapshot dataSnapshot){
    double temp_x=0.0;
    double temp_y=0.0;
    double temp_z=0.0;
    long   temp_val=0;
    String temp_room="";
    float[] translation= new float[3];
    float[] rotation = {0.0f,0.0f,0.0f,0.0f};
    Vector3 wektor3;
    for(DataSnapshot ds : dataSnapshot.getChildren())
    {
        //TODO: create anchors with downloaded values when in the same position use hitpose.creatanchor with pose.

          ObjectConversion vars = ds.getValue(ObjectConversion.class);
          temp_x = vars.getX();
          temp_y = vars.getY();
          temp_z = vars.getZ();
          temp_room = vars.getRoom();
          temp_val=vars.getType();

          translation[0]=(float) temp_x;
          translation[1]=(float) temp_y;
          translation[2]=(float) temp_z;
          wektor3 = new Vector3((float)temp_x,(float)temp_y,(float)temp_z);
          Pose pose = new Pose(translation,rotation);

          Anchor anchorx = download_hit_result.getTrackable().createAnchor(pose);
          AnchorNode anchorNodex = new AnchorNode(anchorx);
          anchorNodex.setParent(arFragment.getArSceneView().getScene());
          anchorNodex.setRenderable(andyRenderable);
    }
}