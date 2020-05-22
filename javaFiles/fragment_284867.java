//first we save the initial matrix, so we can easily get
//back to this state after we're done rotating
canvas.save();
//I *think* you need to negate the center offsets here,
//because you are conceptually moving the canvas, rather
//than moving the center directly
canvas.translate(-cx, -cy);
//<perform the rotation and draw the clock hand>
//...

//and now restore the matrix back to the initial state   
canvas.restore();