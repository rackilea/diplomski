Vector3 tmpVector = new Vector3();
@Override
public boolean touchDragged (int screenX, int screenY, int pointer) {
    Ray ray = cam.getPickRay(screenX, screenY);
    final float distance = -ray.origin.y / ray.direction.y;
    tmpVector.set(ray.direction).scl(distance).add(ray.origin);
    instance.transform.setTranslation(tmpVector);
    return true;
}