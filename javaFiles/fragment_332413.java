DecimalFormatSymbols formatSymbols = new
            DecimalFormatSymbols(Locale.getDefault());
    formatSymbols.setDecimalSeparator(',');
    formatSymbols.setGroupingSeparator(' ');
    final String pattern = "####,####.#####";
    DecimalFormat decimalFormat = new DecimalFormat(pattern, formatSymbols) {
        @Override
        public StringBuffer format(double number, StringBuffer res, FieldPosition fieldPosition) {
            StringBuffer noSpaceOnDecimalPart = super.format(number, res, fieldPosition);

            String result = noSpaceOnDecimalPart.toString();

            if (noSpaceOnDecimalPart != null) {
                int indexOf = noSpaceOnDecimalPart.indexOf(String.valueOf(getDecimalFormatSymbols().getDecimalSeparator()));
                if (indexOf >= 0) {
                    String integerPart = noSpaceOnDecimalPart.substring(0, indexOf);
                    String decimalPart = noSpaceOnDecimalPart.substring(indexOf + 1);

                    StringBuilder formattedDecimal = new StringBuilder("");

                    int i = 0;
                    while (i < decimalPart.length()) {
                        if (i != 0 && i % 3 == 0) {
                            formattedDecimal.append(getDecimalFormatSymbols().getGroupingSeparator());
                        }
                        formattedDecimal.append(decimalPart.charAt(i));
                        i++;
                    }

                    result = integerPart + getDecimalFormatSymbols().getDecimalSeparator() + formattedDecimal;
                }
            }

            return new StringBuffer(result);
        }
    };
    decimalFormat.setGroupingSize(3);
    String number = decimalFormat.format(178500.59999);
    System.out.println(number); // prints 178 500,599 99