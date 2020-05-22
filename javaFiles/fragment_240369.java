dino.setOverlapping(false);
for (Rectangle spacebarRectangle : spacebar.getSpacebarRectangles()) {   // section of code
        if (!dino.isOverlapping() && spacebarRectangle.overlaps(dino.getDinoRectangle())) {
            dino.setOverlapping(true);
            spacebarSound.play();
        }
}