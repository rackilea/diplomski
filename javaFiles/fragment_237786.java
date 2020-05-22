try {
    IntStream.range(1, 3)
        .flatMap(i -> {
            System.out.println("creating "+i);
            return IntStream.range('a', 'a'+i)
                    .peek(j -> {
                        System.out.println("processing sub "+i+" - "+(char)j);
                        if(j=='b') throw new IllegalStateException();
                    })
                    .onClose(() -> System.out.println("closing "+i));
        })
        .forEach(i -> System.out.println("consuming "+(char)i));
} catch(IllegalStateException ex) {
    System.out.println("caught "+ex);
}