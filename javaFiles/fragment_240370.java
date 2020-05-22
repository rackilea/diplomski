for (Rectangle spacebarRectangle : spacebar.getSpacebarRectangles()) {   // section of code
        if (spacebarRectangle.overlaps(dino.getDinoRectangle())) {
            spacebarSound.play();
            break;
        }
}