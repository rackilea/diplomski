public Spatial rotate(Quaternion rot) {
    this.localTransform.getRotation().multLocal(rot);
    setTransformRefresh();

    return this;
}