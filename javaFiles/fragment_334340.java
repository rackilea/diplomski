Map<String, Item> byEffectHavingMaxValue = listItems.stream()
    .collect(Collectors.toMap(
            Item::getEffect,      // group by effect
            Function.identity(),  // keep items as values
            BinaryOperator.maxBy( // when effect exists, keep the item with max value
                    Comparator.comparingInt(i -> Integer.parseInt(i.getValue())))));

Collection<Item> result = byEffectHavingMaxValue.values();