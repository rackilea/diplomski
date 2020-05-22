UpdatingComponent componentToUpdate = new UpdatingComponent(dataSourceToExamine);
panel.add(componentToUpdate);

ComponentUpdater updater = new ComponentUpdater();
updater.addComponent(componentToUpdate);

Timer schedule = new Timer(500, updater);
timer.setRepeats(true);
timer.start();