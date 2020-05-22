mEngine.runOnUpdateThread(new Runnable() {
     @Override
     public void run() {
          ...
          FixtureDef wallfixture = PhysicsFactory.createFixtureDef(0, 0, 0.2f);
          wallfixture.filter.categoryBits = CATEGORY_WALL;
          wallfixture.filter.maskBits = MASK_WALL;
          final Body theBody = PhysicsFactory.createBoxBody(mPhysicsWorld, greenRectangle, BodyType.StaticBody, wallfixture);
          ...
     }
}