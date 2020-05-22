public class ProgressSlider extends JSlider {
    protected int progress;
    private static final String uiClassID = "ProgressSliderUI";

    public ProgressSlider() {
        progress = 0;
        putClientProperty("JSlider.isFilled", Boolean.TRUE);
        updateUI();
    }
    public void updateUI() {
        setUI(new ProgressSliderUI(this));
    }
    public String getUIClassID() {
        return uiClassID;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int value) {
        if (value < this.getMinimum()) {
            this.progress = this.getMinimum();
        }
        else if (value > this.getMaximum()) {
            this.progress = this.getMaximum();
        }
        else {
            this.progress = value;
        }
    }
}