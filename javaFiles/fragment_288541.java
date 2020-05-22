List<String> strlist = Arrays.asList ("One","Two","Three");
Long sumOfLengths = strlist.stream ()
                           .reduce (Long.valueOf (0),
                                    (sum,s) -> sum == null || s == null ? null : sum + s.length(),
                                    (sum1,sum2) -> sum1 == null || sum2 == null ? null : sum1 + sum2);
System.out.println (sumOfLengths);