Double value = 5.500;
DecimalFormat format = new DecimalFormat("0.#");
System.out.println(format.format(value));  // prints 5.5

Double value = 5.000;
DecimalFormat format = new DecimalFormat("0.#");
System.out.println(format.format(value));  // prints 5