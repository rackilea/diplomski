for (int i = 0; i < cudels.length; i++) {
  if (cudels[i] != null) {
    cudels[i].update();
    cudels[i].render();
  }
}