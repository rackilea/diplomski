public class Camera {
    private float price;

    public float getPrice() {
        return price;
    } 
}

public class CameraComparer {
    public float compare (Camera camOne, Camera camTwo) {
        return camOne.getPrice() - camTwo.getPrice();
    }
}