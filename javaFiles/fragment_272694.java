public void renameAGroup(String name) {
        renameGroupButton.click();
        renametGroupInput.clear();
        renametGroupInput.sendKeys(name);
        save.click();
    }