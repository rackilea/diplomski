if (firstClick) {
  handler.postDelayed(singleClickTask, 500);
  firstClick=false;
} else {
  handler.removeCallbacks(singleClickTask);
  firstClick=true;
  //run Y activity
}