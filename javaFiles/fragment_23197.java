int startValue = 1000;
    int endValue = 100000;
    final int factor = 500;
    RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(startValue/factor, endValue/factor, this);
    seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
        @Override
        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
            minValue = minValue*factor
            maxValue *= factor;
            value.setText(minValue + " : " + maxValue);
        }
    });