//Save and rotate canvas 
  canvas.save();
  canvas.rotate(angle, pivotX, pivotY);

  canvas.drawRect(...);

  //restore canvas
  canvas.restore();

  // rotate and draw the second rectangle
  canvas.rotate(angle, pivotX, pivotY);

  canvas.drawRect(...);

  canvas.restore();

  // repeat as necessary