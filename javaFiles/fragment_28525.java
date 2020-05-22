Resources r = getResources();
    Drawable[] layers = new Drawable[2];
    layers[0] = draw;
    layers[1] = r.getDrawable(R.drawable.border);
    LayerDrawable layerDrawable = new LayerDrawable(layers);
    layerDrawable.setLayerInset(0, 0, 0, 0, 12);
    draw = layerDrawable;