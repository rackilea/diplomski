View beneathView = //the view that beneath blur view
View blurView= //blur View

BlurDrawable blurDrawable = new BlurDrawable(beneathView, radius);

blurView.setBackgroundDrawable(blurDrawable);