static class Result {
        int base;
        int times;
    }

    static boolean isCurrentNumberPerfectSquare(double number) {
        return ((number - Math.floor(number)) == 0);
    }

    private static int perfectSquare(int base, int times) {

        int value = base;
        for (int i = times; i > 0; i--) {
            value = (int) Math.pow(base, 2);
        }
        return value;
    }

    private static Result calculatePerfectSquare(int perfectSquare) {

        Result result = new Result();
        result.base = (int) Math.sqrt(perfectSquare);
        result.times = 1;

        while (result.base > 2 && isCurrentNumberPerfectSquare(Math.sqrt(result.base))) {
            result.base = (int) Math.sqrt(result.base);
            result.times += 1;
        }

        System.out.println(perfectSquare + " -> " + result.base + " ^ " + result.times);
        return result;
    }

    static int maxPerfectSquares(int num1, int num2) {

        int largestPerfectSqr = (int) Math.pow(Math.floor(Math.sqrt(num2)), 2);
        if (largestPerfectSqr < num1) {
            return 0;
        }

        Result result = calculatePerfectSquare(largestPerfectSqr);

        int currentValue = result.base;

        while (currentValue > 2) {

            // check lower based values
            currentValue--;

            int newValue = perfectSquare(currentValue, result.times + 1);
            if (newValue >= num1 && newValue < num2) {

                result = calculatePerfectSquare(newValue);
                currentValue = result.base;
            }
        }

        return result.times;
    }