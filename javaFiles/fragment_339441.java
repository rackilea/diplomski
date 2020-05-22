//Use Press Event instead of Click Event
xOffset = event.getSceneX();
yOffset = event.getSceneY();

//Drag Event
window.setX(event.getScreenX() - xOffset);
window.setY(event.getScreenY() - yOffset);