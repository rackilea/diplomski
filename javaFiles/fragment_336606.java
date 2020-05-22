void registerSeekBarsListeners(sliders: Array<SeekBar>) {
  for (SeekBar slider: sliders) {
     slider.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
        // PUT YOUR EVENT LISTENER CODE HERE
     }
  }
}