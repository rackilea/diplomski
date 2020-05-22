if (event.type == TouchEvent.TOUCH_UP) {

 if (inBounds(event, 340,512,140,140)) {
     B1Pressed = false;
     Log.d("GameScreen", "Button 1 Released");
     // Button 1
 }

 if (inBounds(event, 340,320,140,140)) {
     B2Pressed = false;
     Log.d("GameScreen", "Button 2 Released");
     // Button 2
 }

 if (inBounds(event, 340,120,140,140)) {
     B3Pressed = false;
     Log.d("GameScreen", "Button 3 Released");
 // Button 3
 }

 }