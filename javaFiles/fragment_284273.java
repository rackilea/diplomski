Collection<DistributedObject> objects = hazelcastInstance.getDistributedObjects();
for (DistributedObject object : objects) {
  if (object instanceof ILock) {
    handleLock((ILock) object);
  }
}