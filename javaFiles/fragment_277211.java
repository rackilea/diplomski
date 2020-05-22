Predicate<ThirdClass> reject = third -> !titles.contains(third.getField());

firstClassList.forEeach(first ->
    first.getSecondClassList().forEach(second ->
        second.getThirdClassList().removeIf(reject)
    )
);