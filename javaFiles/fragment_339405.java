Map<String, List<String>> data = new HashMap<>();
data.put("EUROPE", Arrays.asList("GERMANY", "FRANCE"));
data.put("USA", Arrays.asList("COLORADO", "CALIFORNIA"));

comboBoxMainCategory.valueProperty().addListener((obs, oldValue, newValue) -> {
        List<String> list = data.get(newValue);
        if (list != null) {
            comboBoxSubCategory.setDisable(false);
            comboBoxSubCategory.getItems().setAll(list);
        } else {
            comboBoxSubCategory.getItems().clear();
            comboBoxSubCategory.setDisable(true);
        }
    });