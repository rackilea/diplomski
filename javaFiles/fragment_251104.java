picker.filterProperty().setValue(new DateFilter() {
        @Override
        public boolean accept(Date date) {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return date.after(parser.parse("2010-07-13"));
            }
            catch (ParseException e) {
                return false;
            }
        }
    });