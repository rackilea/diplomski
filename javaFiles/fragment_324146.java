case TouchEvent.ACTION_UP:
         this.setScale(1.0f);
         this.setZIndex(1);
         this.gGrid.sortChildren();
         Log.d("TOUCH", "ACTION_UP");

             gGrid.cellTouchEvent(this);

         //don't use break 
         //break;
         //instead return true, which means you've handled touch
         return true;