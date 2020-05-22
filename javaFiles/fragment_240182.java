final ArgbEvaluator evaluator = new ArgbEvaluator();
final colorStart = Color.GREEN;
final colorEnd = Color.BLUE;
nestedScrollView.setOnScrollChangedListener((view, scrollX, scrollY, oldX, oldY) -> {
    final float height = (float) v.getHeight();
    if(height <= 0) return;

    final float progress = (float)((float)scrollY/v.getHeight());
    background.setBackgroundColour((int)evaluator.evaluate(progress, startColor, endColor);
});