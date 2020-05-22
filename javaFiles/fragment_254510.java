List<Asset> list=…;
Comparator<Asset> group=Comparator.comparing(Asset::getPaper)
                                  .thenComparing(Asset::getTradeMinutesSinceMidnight);
list.stream().collect(Collectors.groupingBy(
        Function.identity(), ()->new TreeMap<>(group),
        Collectors.summarizingDouble(Asset::getPrice)))
    .forEach((a,p)-> System.out.println(
             a.getPaper()
       +"\t"+a.getTradeMinutesSinceMidnight()
       +"\t"+p.getAverage()
       +"\t"+p.getCount()));