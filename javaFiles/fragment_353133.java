carWashBoxSet.stream()
            .filter(p -> p.getOrderTime() != null)
            .map(t -> t.getOrderTime())
            .max(Date::compareTo)
            .map(boxSet -> boxSet.getMinutes())
            .orElse(/*another value*/);