void separate(float magnitude) {
    Vec3D steer = new Vec3D();
    int count = 0;

    for (int i=0; i<ballCollection.size();i++) {
      Ball other = (Ball) ballCollection.get(i);
      float distance = loc.distanceTo(other.loc);
      if (distance > 0 && distance < 40) {

        Vec3D diff = loc.sub(other.loc);
        diff.normalizeTo(1.0/distance);

        steer.addSelf(diff);
         count++;
      }
    }

    if (count>0) {
        steer.scaleSelf(1.0/count);
    }

      steer.scaleSelf(magnitude);
      acc.addSelf(steer);
  }