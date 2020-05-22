/**
 * Will return the first number of the data array if none of the numbers contain the input number.
 */
public static int findNumberInArrayWithTheMostOccurrences(Integer[] data, int number) {
    //@formatter:off
    Pattern pattern = Pattern.compile(String.valueOf(number));
    Optional<String> result = Arrays.asList(data).stream()
            .map(String::valueOf) //Convert each number to a String
            .max((stringNum1, stringNum2) -> {//Comparing 2 strings
                Matcher m = pattern.matcher(stringNum1);
                int timesOfString1 = 0;
                while (m.find())
                    timesOfString1++;

                m = pattern.matcher(stringNum2);
                int timesOfString2 = 0;
                while (m.find())
                    timesOfString2++;
                return timesOfString1 - timesOfString2;
        });
    //@formatter:on
    return Integer.parseInt(result.get());
}