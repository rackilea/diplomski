((10.0f - 5.0f) / 0.1f) + 1 = 51 increments (0 to 50)

updateSlider(float value) {
  if (value > 10.0f) {
    Slider.setValue(50);
  } else if (value < 5.0f) {
    Slider.setValue(0);
  } else {
    Slider.setValue((int)Math.round((value - 5.0f)/0.1f));
  }
}

float updateFloat(Slider slider) {
  int value = slider.getValue();
  return 5.0f + (slider.getValue() * 0.1f);
}