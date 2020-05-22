float progressStart = 0.5f
float progressEnd = 1f;
float progressDelta = progressEnd - progressStart;

float progress = (position - progressStart)/progressDelta;
if(progress>1)progress=1;
if(progress<0)progress=0;

float endValue = 1f;
float startValue = 0.8f;

float delta = endValue - startValue;
float currentScale = startValue + delta*progress;

ViewCompat.setScaleX(page, currentScale);