wheelHorizontalView1.addChangingListener(changedListener);
    ...
    ...  
    // Wheel changed listener
    private OnWheelChangedListener changedListener = new OnWheelChangedListener() {
        public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
            // newValue is the currently selected item
        }
    };