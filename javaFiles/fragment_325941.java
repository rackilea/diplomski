for (int term = 0; term < poly.length - 1; term += 2) {
            try {
                coefficient = Double.parseDouble(poly[term]);
                exponent = Integer.parseInt(poly[term + 1]);
                numTerms++;
                this.addTerm(coefficient, exponent);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }