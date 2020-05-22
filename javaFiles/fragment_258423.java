NumberFormat format = new DecimalFormat("#.#E0");
    yAxis.setTickLabelFormatter(new StringConverter<Number>() {

        @Override
        public String toString(Number number) {
            return format.format(number.doubleValue());
        }

        @Override
        public Number fromString(String string) {
            try {
                return format.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return 0 ;
            }
        }

    });