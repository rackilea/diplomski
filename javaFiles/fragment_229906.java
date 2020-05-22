public static void main(String[] args) {
    String input = "DATA_PATH=/data/${PROJECT}/${YEAR}${MONTH}${DAY}";
    Map<String, String> env = new HashMap<>();
    env.put("PROJECT", "myProject");
    env.put("YEAR", "2017");
    env.put("MONTH", "7");
    env.put("DAY", "5");
    env.put("OTHER_VALUE", "someOtherValue");
    System.out.println(StrSubstitutor.replace(input, env));
}