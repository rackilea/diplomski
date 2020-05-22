private final class TileOnTouchListener implements OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                player.setX((int)e.getX());
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
            }
            return true;
        }
    }