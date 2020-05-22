return _allCostPlanDetailRows
      .entrySet()
      .stream()
      .sorted( sortingOrder_ == SortingOrder.DESC ? Map.Entry.<String, String>comparingByValue(Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER)).reversed() : Map.Entry.comparingByValue(Comparator.nullsFirst(
          String.CASE_INSENSITIVE_ORDER)) )
      .map( Map.Entry::getKey )
      .collect( Collectors.toList() );