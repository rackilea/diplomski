boolean[] cameraPermissionGranted = {false};
boolean cameraPermission = false;
List<Integer> list = new ArrayList<>();
list.forEach(a -> {
    cameraPermissionGranted[0] = true; // effectively final
    // cannot use cameraPermission
});