List<FooBO> list1 = objects.get(1).getObjects().stream()
                                  .filter (o -> (o instanceof BarBo))
                                  .map (o -> (BarBO)o)
                                  .flatMap (b -> b.getAffiliates().stream())
                                  .map(BazBo::getPriceList)
                                  .collect(Collectors.toList());