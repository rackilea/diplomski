public class NextTime {

public static void main(String[] args) {

    String time = "12:12";
    System.out.println("Starting time="+time);
    System.out.println("Next time="+getNextTime(time));
}

static Set<Integer> times = new HashSet<>();

private static String getNextTime(String time) {
    // Create a list with the 4 digits (strip out the ':')
    List<String> digits = Arrays.asList(time.split("")).stream().filter(d -> !d.equals(":"))
            .collect(Collectors.toList());
    // Build up the set of maximum 24 times
    timeCombinations(digits, 0, "");
    // Sort the list of times (which are integers representing minutes)
    List<Integer> sortedTimeList = times.stream().sorted().collect(Collectors.toList());
    // Find the next index immediately after the current time
    int newIndex = 0;
    if (sortedTimeList.size() > 1) {
        int currentTime = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
        int listPosition = sortedTimeList.indexOf(currentTime);
        newIndex = (listPosition + 1) % times.size();
    }
    // Turn the time back into a string
    String newTimeString = String.format("%02d:%02d", sortedTimeList.get(newIndex)/60, sortedTimeList.get(newIndex)%60);
    return newTimeString;
}

private static void timeCombinations(List<String> digits, int depth, String result) {
    if (depth == 4) {
        // You have a valid time; Convert time string like 1234 to minutes
        int minutes = Integer.valueOf(result.substring(0, 2)) * 60 + Integer.valueOf(result.substring(2, 4));
        times.add(minutes);
    } else {
        for (int d = 0; d < digits.size(); d++) {
            int c = Integer.valueOf(digits.get(d)).intValue();
            // Validation rule for the first digit of the hour
            if (depth == 0 && c > 2)
                continue;
            // Validation rule for the first digit of the minutes
            if (depth == 2 && c > 5)
                continue;
            List<String> digitsClone = new ArrayList<>(digits);
            String resultClone = new String(result) + digitsClone.get(d);
            // Validation rule for the complete hour
            if (depth == 1 && Integer.valueOf(resultClone).intValue() > 23)
                continue;
            digitsClone.remove(d);
            timeCombinations(digitsClone, depth + 1, resultClone);
        }
    }
}