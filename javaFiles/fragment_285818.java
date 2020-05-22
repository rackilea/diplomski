static List<Integer> controlOccurrences(List<Integer> sortedArr, int m) {
            //make the count of each element
            Map<Integer, Long> result = sortedArr.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


            for (Map.Entry<Integer, Long> entry : result.entrySet()) {
                if (entry.getValue() == m) {
                    // Here 2 is hard coded. You can make a variable and pass it to the method with a parameter
                    for (int i = 0; i < m - 2; i++) 
                    {
                        sortedArr.remove(entry.getKey());
                    }
                }
            }

            return sortedArr;
        }