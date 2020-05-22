Multimap<Integer, Detail> detailsByAppId = Multimaps.index(detailList,
        new Function<Detail, Integer>() {
          @Override
          public Integer apply(Detail detail) {
            return detail.getAppId();
          }
        }
);