if (scheduleSettings == 0)
    nav_menu.findItem(R.id.scheduleSettingsSideBar).setVisible(true);

else if (randomDelay == 0)
    nav_menu.findItem(R.id.randomDelaySideBar).setVisible(false);

else if (temperatureSettings == 0)
    nav_menu.findItem(R.id.tempSettingsSideBar).setVisible(false);

else if (humiditySettings == 0)
    nav_menu.findItem(R.id.humiditySettingsSideBar).setVisible(false);

else if (manualControl == 0)
    nav_menu.findItem(R.id.manualSettingsSideBar).setVisible(false);

else if (logging == 0)
    nav_menu.findItem(R.id.loggingSideBar).setVisible(false);

else if (generalSettings == 0)
    nav_menu.findItem(R.id.generalSettingsSideBar).setVisible(false);