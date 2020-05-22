public Drawable getMyDrawable() {
        StateListDrawable states = new StateListDrawable();

//        states.addState(new int[]{
//                -android.R.attr.state_enabled,
//        }, getDisableDrawable());

        states.addState(new int[]{
                android.R.attr.state_focused, -android.R.attr.state_pressed,
        }, getDrawable(true));
        states.addState(new int[]{
                android.R.attr.state_focused, android.R.attr.state_pressed,
        }, getDrawable(true));
        states.addState(new int[]{
                -android.R.attr.state_focused, android.R.attr.state_pressed,
        }, getDrawable(true));
        states.addState(new int[]{
                android.R.attr.state_enabled
        }, getDrawable(false));

        return states;
    }

    public Drawable getDrawable(boolean pressed) {
        Drawable[] normalDrawable = new Drawable[2];
        normalDrawable[0] = getRectBorder(pressed);
        normalDrawable[1] = getRectBG();

        LayerDrawable layerDrawable = new LayerDrawable(normalDrawable);
        layerDrawable.setLayerInset(1, 2, 2, 2, 2);

        return layerDrawable.mutate();
    }

    public Drawable getRectBorder(boolean pressed) {
        RectShape rectShape = new RectShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
        shapeDrawable.getPaint().setColor(pressed ? Color.RED : Color.BLACK);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth(2);
        shapeDrawable.getPaint().setAntiAlias(true);
        shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
        return shapeDrawable.mutate();
    }

    public Drawable getRectBG() {
        RectShape rectShape = new RectShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
        shapeDrawable.getPaint().setColor(Color.WHITE);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setAntiAlias(true);
        shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
        return shapeDrawable.mutate();
    }