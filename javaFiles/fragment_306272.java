add(level.getName()).bottom().left().colspan(2).expand();
add(image).width(30f).height(30f);
row();
add(level.getOwner()).top().left().colspan(3).expand();
row();
Table buttons = new Table();

buttons.add(playButton).padRight(10f);
buttons.add(editButton);

add(buttons).expand().colspan(3).left();