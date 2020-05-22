try {
        Optional<byte[]> img = loadImageFromDatabase(jtextField1.getText().trim());
        img.ifPresent(image -> {
                ...
            });
    } catch (SQLException e) {