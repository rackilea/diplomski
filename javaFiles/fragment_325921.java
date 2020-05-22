// Create a Fade instance and add it to the frame
Fade fade = new Fade();
frame.add(fade);
...

// Submit the SAME Fade instance to the executor
executor.execute(fade);