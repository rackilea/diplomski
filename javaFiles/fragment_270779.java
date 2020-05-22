@Test
    public void test() {
        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(1);
        ObjectBinding<Color> binding = Bindings
                .createObjectBinding(() -> converToColor(simpleIntegerProperty.get()), simpleIntegerProperty);
        System.out.println(binding.get());
        binding.addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                System.out.println(newValue);
            }
        });
        simpleIntegerProperty.set(2);
    }

    private Color converToColor(int i) {
        switch (i) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
        }
        return null;
    }