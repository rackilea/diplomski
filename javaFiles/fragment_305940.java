public class JavaApplication1
{

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 3, 7, 6, 8, 3);
        for (Integer integer : list) {
            List<Integer> runList = new ArrayList<>(list);
            runList.remove(integer);
            Result result = getOperations(runList, integer, 348);
            if (result.success) {
                System.out.println(integer + result.output);
                return;
            }
        }
    }

    public static class Result
    {

        public String output;
        public boolean success;
    }

    public static Result getOperations(List<Integer> numbers, int midNumber, int target)
    {
        Result midResult = new Result();
        if (midNumber == target) {
            midResult.success = true;
            midResult.output = "";
            return midResult;
        }
        for (Integer number : numbers) {
            List<Integer> newList = new ArrayList<Integer>(numbers);
            newList.remove(number);
            if (newList.isEmpty()) {
                if (midNumber - number == target) {
                    midResult.success = true;
                    midResult.output = "-" + number;
                    return midResult;
                }
                if (midNumber + number == target) {
                    midResult.success = true;
                    midResult.output = "+" + number;
                    return midResult;
                }
                if (midNumber * number == target) {
                    midResult.success = true;
                    midResult.output = "*" + number;
                    return midResult;
                }
                if (midNumber / number == target) {
                    midResult.success = true;
                    midResult.output = "/" + number;
                    return midResult;
                }
                midResult.success = false;
                midResult.output = "f" + number;
                return midResult;
            } else {
                midResult = getOperations(newList, midNumber - number, target);
                if (midResult.success) {
                    midResult.output = "-" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber + number, target);
                if (midResult.success) {
                    midResult.output = "+" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber * number, target);
                if (midResult.success) {
                    midResult.output = "*" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber / number, target);
                if (midResult.success) {
                    midResult.output = "/" + number + midResult.output;
                    return midResult
                }
            }

        }
        return midResult;
    }
}