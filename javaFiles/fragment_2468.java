private boolean clicking = false;
public void nativeMousePressed(NativeMouseEvent e) {
   clicking = true;
      if (!disable) {
         if (e.getButton() == MouseEvent.BUTTON1) {
            if (!randomCPS) {
              robotClick(cps, typeOfClick);
              } else if (randomCPS) {
            robotRandomizedBetweenClicks(fromCPS, toCPS, typeOfClick);
            }
       }
    }
 }


public void nativeMouseReleased(NativeMouseEvent e) {
  clicking = false;
  if (e.getButton() == MouseEvent.BUTTON1) {
    disable = true;
    running = false;
}
}