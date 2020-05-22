Rectangle node2 = 
  RectangleBuilder.create()
    .x(-100)
    .y(-100)
    .width(200)
    .height(200)
    .fill(
      new ImagePattern(
        new Image("file:flower.png"), 0, 0, 1, 1, true
      )
    )
    .build();