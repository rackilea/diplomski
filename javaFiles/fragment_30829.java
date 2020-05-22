IntStream.range(0, 256)  // generate a stream of integers from 0-255
    .map(i -> {  // map each integer to a pawn with that integer as its id
        LcPawn pawn = new LcPawn();
        pawn.setId(i);
        return pawn;
    })
    .forEach(System.out::println);  // print all of them, using a "method reference"