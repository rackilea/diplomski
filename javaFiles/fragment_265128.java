protected final void destroyBody(World physics)
{
  Gdx.app.debug(this.getClass().getSimpleName(), "destroying body" );
  if(body != null)
  {
     final Array<JointEdge> joints = body.getJointList();
     while (joints.size > 0)
     {
        Gdx.app.log("GameWorld", "destroying joint" );
        Joint joint = joints.get(0).joint;
        physics.destroyJoint(joint);
        joints.removeIndex(0);
     }
     physics.destroyBody(body);
  }
  else
  {
     Gdx.app.error(this.getClass().getSimpleName(), "entity's body not found. No action taken." );
  }