public static double variance(ArrayList<Double> numbers) {
        double variance = 0;
        for (int i = 0; i <numbers.size(); i++) {
            variance = variance + Math.pow((numbers.get(i) - mean(numbers)), 2);
        }
        return variance/numbers.size();
    }