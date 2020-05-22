MyTriangleEdge edgeTreatment = new MyTriangleEdge(height,false);

LinearLayout linearLayout= findViewById(R.id.xxxx);
ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel()
    .toBuilder()
    .setBottomEdge(edgeTreatment)
    .build();

MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);

ViewCompat.setBackground(linearLayout,shapeDrawable);