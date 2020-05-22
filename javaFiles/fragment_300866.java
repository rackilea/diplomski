NumberFormat amountFormat = NumberFormat.getNumberInstance();
amountFormat.setMinimumIntegerDigits(1);
amountFormat.setMaximumIntegerDigits(3);
amountFormat.setMaximumFractionDigits(0);

amountField = new JFormattedTextField(amountFormat);