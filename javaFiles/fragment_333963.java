Coverage mainCoverage = 
          illus.getLifes()
               .stream()
               .filter(Life::isIsmain)               
               .map(Life::getCoverages)
               //.filter(Objects::nonNull) uncomment if there can be null lists
               .flatMap(Collection::stream) // <--- collapse the nested sequences
               //.filter(Objects::nonNull) // uncomment if there can be null Coverage
               .filter(Coverage::isMainplan)
               .findFirst().orElse(...);