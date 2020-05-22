xAxis.setTickLabelFormatter(new StringConverter<Number>() {
        @Override
        public String toString(Number object) {
            return (object.intValue() * 0.25) + "s";
        }

        @Override
        public Number fromString(String string) {
            return 0;
        }
    });