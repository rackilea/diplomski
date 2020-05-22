@Override
public void handle(long now) {

    // existing code...

    if (jumpforce < 0) {
        iview.setImage(jumpingImage);
    } else {
        iview.setImage(imgninja);
    }

    // ...
}