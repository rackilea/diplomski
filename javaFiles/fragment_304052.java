Map<Integer, BigDecimal> map = filteredList.stream()
        .filter(s -> ("AF").equals(s.getCountry()))
          .collect(
              Collectors.toMap(
                 s -> ((MyObject)s).getYear(),
                 s -> ((MyObject)s).getValue())
         );
System.out.println("(year,value) for AF Country are:");
System.out.println(map);