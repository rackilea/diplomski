for (int i=0;i<4;i++) {
            if (executed == true && !(sprite[zahl[i]].getBoundingRectangle().contains(touchPoint.x,
                    touchPoint.y)) && zahl[4] != zahl[i]) {
               // touched right colour
               atLeastOneTouched = true;
               lastTouched = 3f; // reset timer
            }
        }