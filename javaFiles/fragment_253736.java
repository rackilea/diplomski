public class SliderUI extends MetalSliderUI {

    private boolean displayThumb = false;

    public SliderUI(){
        super();
    }


  @Override
    public void paintThumb(Graphics g) {
      if(displayThumb){
          super.paintThumb(g);
      }
    }

    @Override
    protected void scrollDueToClickInTrack(int direction) {
        //keep displaying thumb once true
        if(!displayThumb){
            displayThumb = true;
        }
        int value = slider.getValue(); 
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            value = this.valueForXPosition(slider.getMousePosition().x);
        } else if (slider.getOrientation() == JSlider.VERTICAL) {
            value = this.valueForYPosition(slider.getMousePosition().y);
        }
        slider.setValue(value);
    }
}