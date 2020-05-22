Total total = objects.stream()
        .map(o -> (A) o)
        .collect(Total::new,
                (t, a) -> {
                    t.addA(a.getA());
                    t.addB(a.getB());
                },
                (t1, t2) -> { });
//check total.getTotalA() and total.getTotalB()