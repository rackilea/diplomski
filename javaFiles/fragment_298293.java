@RequestMapping(method = RequestMethod.GET)
    public void loadSettings(Model model) {
        if (!model.containsAttribute("settings")) {
          model.addAttribute("settings", new Settings());
        }
        model.addAttribute("settingsList", settingsService.getAllSettings();
    }