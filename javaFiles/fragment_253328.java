public static void main(String... aArgs) {
   List<String> domainDailyData1 = Arrays.asList(new String[]{
        "gmail.com", "172.11.0.89", "1",
        "gmail.com", "172.11.0.89", "60",
        "gmail.com", "192.168.0.66", "13"});

    // >>> convention: don't use capital letter as the first letter of a variable
    List<String> finalData1 = new ArrayList<>();

    // getting the total count 
    for (int l = 1; l < domainDailyData1.size(); l += 3) {
        String tempIP1 = domainDailyData1.get(l);

        // 2. to avoid looping an IP that you already counted
        if (!finalData1.contains(tempIP1)) {

            System.out.println("The IP " + tempIP1);

            // 1. num1 initialisation
            int num1 = 0;

            for (int e = 1; e < domainDailyData1.size(); e += 3) {

                // 3. iterator confusion
                String tempIP2 = domainDailyData1.get(e);

                if (tempIP2.equals(tempIP1)) {
                    String str1 = domainDailyData1.get(e + 1);
                    int temp1 = Integer.parseInt(str1);
                    num1 += temp1;
                }
            }

            finalData1.add(tempIP1);
            finalData1.add(String.valueOf(num1));
        }
    }

    System.out.println("The Data in Final Data is :" + finalData1);
}