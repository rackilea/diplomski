// instantiate 2 DummyTC's with impossibly high cost &durations

TravelCost cheapest = new DummyTC(99999999999.99, 99999999999.99);
TravelCost shortest = new DummyTC(99999999999.99, 99999999999.99);

// iterate over the List

for(TravelCost tc : AL) {
    // if present tc is cheaper than cheapest, swap
    if ( tc.getCost() < cheapest.getCost() ) {
        cheapest = tc;
    }
    // if present tc is shorter than shortest, swap
    if ( tc.getDuration() < shortest.getDuration() ) {
        shortest = tc;
    }
}

// at this point cheapest and shortest will contain the cheapest and shortest 
// ways of transportation, so we print them out.

System.out.println(cheapest.toString());
System.out.println(shortest.toString());