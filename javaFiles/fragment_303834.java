myList.stream()
            .filter(item -> someMethod(item))
            .map(item -> doSomething(item))
            .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                if (result.isEmpty()) throw new RuntimeException("Empty!!");
                return result;
            }));