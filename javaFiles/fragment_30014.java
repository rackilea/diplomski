Resources r = getResources();
Drawable[] layers = new Drawable[2];
layers[0] = r.getDrawable(R.drawable.yourImage);;
layers[1] = r.getDrawable(R.drawable.yourFrame);
LayerDrawable layerDrawable = new LayerDrawable(layers);
imageView.setImageDrawable(layerDrawable);