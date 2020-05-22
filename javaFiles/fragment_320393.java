decalBatch = new DecalBatch();
CameraGroupStrategy cameraGroupStrategy = new CameraGroupStrategy(camera);
decal = Decal.newDecal(textureRegion, true);
decal.setPosition(5, 8, 1);
decal.setScale(0.02f);
decalBatch.setGroupStrategy(cameraGroupStrategy);