comboBoxMainCategory.valueProperty().addListener((obs, oldValue, newValue) -> {
        if (newValue == null) { // newValue: Europe || USA
            comboBoxSubCategory.getItems().clear();
            comboBoxSubCategory.setDisable(true);
        } else {
            comboBoxSubCategory.setDisable(false);
            List<? extends Object> list;
            switch (newValue) {
                case EUROPE:
                    list = Arrays.asList(SubCategoryEurope.values());
                    break;
                default:
                    list = Arrays.asList(SubCategoryUSA.values());
                    break;
            }
            comboBoxSubCategory.getItems().setAll(list);
        }
    });