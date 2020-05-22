// member variables:
float timeToCameraZoomTarget, cameraZoomTarget, cameraZoomOrigin, cameraZoomDuration;

private float zoomTo (float newZoom, float duration){
    cameraZoomOrigin = camera.zoom;
    cameraZoomTarget = newZoom;
    timeToCameraZoomTarget = cameraZoomDuration = duration;
}

// in render():
if (timeToCameraZoomTarget >= 0){
    timeToCameraZoomTarget -= deltaTime;
    float progress = timeToCameraZoomTarget < 0 ? 1 : 1f - timeToCameraZoomTarget / cameraZoomDuration;
    camera.zoom = Interpolation.pow3out.apply(cameraZoomOrigin, cameraZoomTarget, progress);        
}