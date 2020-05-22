@Test
public void thirdDeepLevel() {
    Observable.from(Arrays.asList("a", "b", "c", "d", "e"))
            .flatMap(letter -> Observable.from(Arrays.asList(1, 2, 3, 4, 5))
                    .map(number -> {
                        System.out.println(letter + ":" + number);
                        return number;
                    })
                    .filter(number -> number == 4)
                    .flatMap(number -> Observable.from(Arrays.asList("f", "g", "h", "i"))
                            .map(leter2 -> {
                                System.out.println(letter + ":" + number);
                                return leter2;
                            })))
            .subscribe();
}