Supplier<Integer> integerSupplier = new Supplier<Integer>();
Consumer<Integer> integerConsumer = new Consumer<Integer>();
Integer i = integerSuppler.supplyItem();
integerConsumer.consumeItem(i);
integerConsumer.consumeItem(integerSupplier.supplyItem());
System.out.println(integerConsumer.consumeCount());