NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);


edittext.setText(String.valueOf(nf.format(Your value)));