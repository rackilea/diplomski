boolean toLeft = false;
int size = 5;

int half = size % 2 == 0 ? size / 2 : size / 2 + 1;
IntStream inferiorStream = IntStream.iterate (half, x -> x - 1);
IntStream superiorStream = IntStream.iterate (half, x -> x + 1);

OfInt a = toLeft 
          ? inferiorStream.iterator () 
          : superiorStream.iterator ();
OfInt b = toLeft 
          ? superiorStream.skip (1).iterator () 
          : inferiorStream.skip (1).iterator ();

IntStream stream = Stream.generate (() -> IntStream.concat (
    a.hasNext () ? IntStream.of (a.nextInt ()) : IntStream.empty (),
    b.hasNext () ? IntStream.of (b.nextInt ()) : IntStream.empty ()))
    .flatMapToInt (Function.identity ())
    .limit (size);

stream.forEach (System.out :: println);