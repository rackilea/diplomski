double parsed;
            try {
                parsed = Double.parseDouble(stringValue);
            } catch (NumberFormatException e) {
                parsed = 0.00;
            }