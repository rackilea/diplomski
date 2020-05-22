Skin skin = SkinManager.getInstance().getSkin();
    final Table outerTable = new Table();
    outerTable.setFillParent(true);
    stage.addActor(outerTable);

    // Layer to hold the buttons and dark background
    Table buttonsTable = new Table();

    playButton = new TextButton("Play", skin, "play");
    settingsButton = new TextButton("Setting", skin, "setting");
    highScoreButton = new TextButton("Leaders", skin, "leaders");

    buttonsTable.add(playButton).width().height().pad();
    buttonsTable.row();
    buttonsTable.add(settingsButton).width().height().pad(0);
    buttonsTable.row();
    buttonsTable.add(highScoreButton).width().height().pad();
    buttonsTable.row();
    // + background color
    buttonsTable.setBackground(controlsBackground);

    // Adding button table to outer table
    outerTable.add(buttonsTable).colspan(2).expand();