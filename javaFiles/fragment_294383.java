private static class AutoDecrementer implements Runnable {

    AutoDecrementer (ValueSelector valueSelector ){
       this.weakRef = new WeakReference<>(valueSelector);
    }      


    @Override
    public void run() {
         ValueSelector valueSelector =  (ValueSelector )weakRef.get();
         if(valueSelector == null){
            return ;
          }  

        if (valueSelector.minusButtonIsPressed) {
            valueSelector .decrementValue();
            valueSelector .mHandler.postDelayed(new AutoDecrementer(), REPEAT_INTERVAL_MS);
        } else {
            valueSelector.mHandler.removeCallbacks(this);
            Thread.currentThread().interrupt();
        }
    }
}