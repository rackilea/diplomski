...

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float Foo=0;
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                Foo-=0.1f;
                return true;
            }