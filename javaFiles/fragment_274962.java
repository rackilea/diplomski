public static void main(String[] args) {
    System.out.println(checkDays("Wed,Tue,Mon,Thu,Sun,Fri,Sat")); // true
    System.out.println(checkDays("Tue,Mon,Thu,Sun,Fri,Sat"));     // false
}

static List<String> allDays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
public static boolean checkDays(String days) {
    return Arrays.asList(days.split(",")).containsAll(allDays);
}