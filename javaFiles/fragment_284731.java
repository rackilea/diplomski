private void scheduleButAlsoReschedule(final View v){
            v.getHandler().removeCallbacksAndMessages(null);
            v.getHandler().postDelayed(new Runnable(){

                @Override
                public void run() {
                // do something here, Note: this is UI-thread
                }}, DISMISS_DELAY);
        }