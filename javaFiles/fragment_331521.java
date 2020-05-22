private void configureDiscountBinding() {
    discountValue.addListener(new ChangeListener<BigDecimal>() {
        private boolean changing;

        @Override public void changed(ObservableValue<? extends BigDecimal> observable, BigDecimal oldValue, BigDecimal newValue) {
            if( !changing ) {
                try {
                    changing = true;
                    discountRate.set(newValue.multiply(new BigDecimal("100")).divide(getTotalValue(), RoundingMode.HALF_DOWN));
                }
                finally {
                    changing = false;
                }
            }
        }
    });

    discountRate.addListener(new ChangeListener<BigDecimal>() {
        private boolean changing;

        @Override public void changed(ObservableValue<? extends BigDecimal> observable, BigDecimal oldValue, BigDecimal newValue) {
            if( !changing ) {
                try {
                    changing = true;
                    discountValue.set(newValue.multiply(getTotalValue()).divide(new BigDecimal("100"), RoundingMode.HALF_DOWN));
                }
                finally {
                    changing = false;
                }
            }
        }
    });
}