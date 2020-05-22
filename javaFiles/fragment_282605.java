// Initialize
 VerticalGroup v = new VerticalGroup();
 v.addActor(new Label("First row", skin))
 v.addActor(new Label("Second Row", skin))
 v.pack();
 myScene.addActor(v);

 ...

 // Add to the 'top'
 v.addActorAt(0, new Label("I'm at the first row", skin));
 v.pack();