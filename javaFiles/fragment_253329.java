public static void main(String... aArgs) {

    List<String> domainDailyData1 = Arrays.asList(new String[]{
        "gmail.com", "172.11.0.89", "1",
        "gmail.com", "172.11.0.89", "60",
        "gmail.com", "192.168.0.66", "13"});

    // Result is a map as it is a pairing <IpAddress, Count>
    Map<String, Integer> countMap = Stream
            // Start with index = 1 and then jump by step of 3                
            .iterate(1, i -> i + 3)
            // Get the number of ip address to scan. A row a basically the 
            // triplet {domain, ip address, count} as I defined for the input.
            //
            // Integer division: if list size is below 3, then the result is
            // 0 and nothing happens. If the list size is not a multiple of
            // 3, for example, 11, then the result is 3 and last rows (index
            // from 8 to 10) are ignored
            .limit(domainDailyData1.size() / 3)
            // optional line but if you want to know what's currently happening...
            .peek(i -> System.out.println("Checking IP Address: " + domainDailyData1.get(i)))
            // Result is a map as it is a pairing <IpAddress, Count>
            .collect(Collectors.toMap(
                    // The key is of course the ip address which is at 
                    // position i. What's nice with Map is that if a another
                    // identical ipaddress is found, the key are merged. That's
                    // why it is necessary to define a merge function
                    i -> domainDailyData1.get(i),
                    // fetch the count associated with index i. As one never
                    // trust unknown input, any invalid count means zero
                    i -> {
                        try {
                            // Just get the count. The i+1 is not supposed
                            // to trigger the ArrayOutOfBoundException as 
                            // guaranteed by the .limit() above
                            Integer count = Integer.parseInt(domainDailyData1.get(i + 1));
                            return count;
                        }
                        catch (NumberFormatException e) {
                            // silent exception catching but you can do
                            // anything here
                            return 0;
                        }
                    },
                    // If two ip addresses are found, just sum the count
                    // The static method reference form is Integer::sum
                    (oldCount, newCount) -> oldCount + newCount
                )
            );

    System.out.println(countMap);
}