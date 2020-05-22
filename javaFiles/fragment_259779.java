private void calculateProducedEnergy() {
 for (Integer s: mWeatherProfile.getSunshine()) {
  for (Double w: mWeatherProfile.getWeatherConditions()) {
   mProducedEnergy.add(s * w * mPvSystem.getEfficiency() * mPvSystem.getPanelSurface());
  }
 }
}