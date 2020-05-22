Stream.<Supplier<List<Object>>>of(() -> method1(), 
                                  () -> method2(), 
                                  () -> method3(), 
                                  () -> method4(), 
                                  () -> method5(), 
                                  () -> method6())
    .map(Supplier<List<Object>>::get)
    .filter(l -> !l.isEmpty())
    .findFirst()
    .ifPresent(list::addAll);

return list;