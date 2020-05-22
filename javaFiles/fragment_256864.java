Collection<Drink> c = 
       list.stream().collect(Collectors.groupingBy(Drink::getName,
            Collectors.collectingAndThen(
                Collectors.reducing((Drink a, Drink b) -> {
                   a.setAmount(a.getAmount() + b.getAmount());
                   return a;
            }), Optional::get))).values();