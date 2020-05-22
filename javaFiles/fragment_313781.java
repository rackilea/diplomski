Paint bubblePaint;
 Paint bookedBubblePaint;

  //list of bubbles available
  SparseArray<Bubble> mBubbleMap = new SparseArray<Bubble>();

  //list of bubbles already booked
  SparseArray<Bubble> bookedBubble = new SparseArray<Bubble>();

protected void drawBubbles(Canvas canvas) {
        for (int i = 0; i < mBubbleMap.size(); i++) {
            int key = mBubbleMap.keyAt(i);
            Bubble b = mBubbleMap.get(key);
            if (b != null) {
                b.onDraw(canvas, false);//send info of booked status

            }
        }

        for (int i = 0; i < bookedBubble.size(); i++) {
            int key = bookedBubble.keyAt(i);
            Bubble b = bookedBubble.get(key);
            if (b != null) {
                b.onDraw(canvas, true);//send info of booked status

            }
        }
    }