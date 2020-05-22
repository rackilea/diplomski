public class Camera {
    public float price;
}

public class CameraComparer {
    public float compare (Camera camOne, Camera camTwo) {
        // do something; e.g. return difference
        return camOne.price - camTwo.price;
    }
}