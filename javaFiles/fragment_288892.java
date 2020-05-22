int startOffset = 200;

for(int i=0; i < textViews.length(); i++){
    animSlideIn.setStartOffset(startOffset);
    textViews[i].setVisibility(View.Visible);
    textViews[i].startAnimation(animSlideIn);
    startOffset = startOffset + 200;
}