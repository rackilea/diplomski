if (value == addButtonType) {
        Batch b = new Batch();
        b.setCode(code.getText());
        b.setName(name.getText());
        return b;
    }