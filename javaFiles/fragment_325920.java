// Here you are adding a "Fade" instance to the frame.
frame.add(new Fade());
...

// Here you are creating a NEW "Fade" instance. Only in 
// this instance, the alpha value will be affected
Runnable fade = new Fade();
executor.execute(fade);