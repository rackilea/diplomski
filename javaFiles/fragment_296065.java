interface UberList<U> extends List<U extends Uber> {
    U firstUber();
    <D extends Driver> D driver();
}

uberList = mock(UberList.class, RETURNS_DEEP_STUB);

Uber u1 = uberList.iterator().next();
Uber u1 = uberList.firstUber();
Driver d = uberList.driver();