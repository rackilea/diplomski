private void calculateProducedEnergy() {
 int counter = 0;
 for (Integer s: mWeatherProfile.getSunshine()) {
  for (Double w: mWeatherProfile.getWeatherConditions()) {
   mProducedEnergy[counter++] = s * w * mPvSystem.getEfficiency() * mPvSystem.getPanelSurface();
  }
 }
}