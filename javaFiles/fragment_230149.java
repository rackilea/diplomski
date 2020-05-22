int first_number = 10;
    int second_number = 20;
    IntBinaryOperator subtract = (n1, n2) -> n1 - n2; // Subtract second from first value
    IntUnaryOperator determineSign = n -> Integer.signum(n); // Determine the sign of the subtraction
    IntFunction<String> message = key -> { // Sign of 0 means value has been 0 (first_number == second_number). Sign of 1 = positive value, hence equals first_number > second_number, otherwise return the default.
        Map<Integer, String> messages = new HashMap<>();
        messages.put(0, "PERFECT");
        messages.put(1, "ABUNDANT");
        return messages.getOrDefault(key, "DEFICIENT");
    };

     return message.apply(determineSign.applyAsInt(subtract.applyAsInt(first_number, second_number)));