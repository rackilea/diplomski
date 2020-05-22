stage.addActor(root);
root.add(image).width(200).height(200);
root.row();
root.add(new Label("Loading...", skin));
root.row();
//Use groups to overlay multiple images
Group group = new Group();
progressBarBG.setWidth(600);
progressBarFG.setSize(30, 30);
group.addActor(progressBarBG);
group.addActor(progressBarFG);
root.add(group);
root.pack();
Gdx.input.setInputProcessor(stage);