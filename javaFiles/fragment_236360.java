// We get the current position of the Activity
final int currentX = getActivityPositionX();
final int currentY = getActivityPositionY();

// The new position is set
setActivityPosition(x, y);

// We animate the Activity to slide from its previous position to its new position
TranslateAnimation animation = new TranslateAnimation(currentX - x, 0, currentY - y, 0);
animation.setDuration(500);
this.content.startAnimation(animation);