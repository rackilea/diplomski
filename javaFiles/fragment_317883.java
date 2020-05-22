public static void main(String[] args) {

    // your data map
    Map<GC, List<RR>> map;

    // the map entry set as list, which will help
    // combining the elements
    //
    // note this is a modifiable list

    List<Map.Entry<GC, List<RR>>> mapEntryList =
            new ArrayList<Map.Entry<GC, List<RR>>>(map.entrySet());

    // the combinations list, which will store
    // the desired results

    List<RR> combinations = new ArrayList<RR>();

    doRecursion(mapEntryList, combinations);
}

private static void doRecursion(
        List<Map.Entry<GC, List<RR>>> mapEntryList,
        List<RR> combinations) {

    // end of recursion

    if (mapEntryList.isEmpty()) {

        // do what you wish
        //
        // here i print each element of the combination

        for (RR rr : combinations) {

            System.out.println(rr);
        }

        System.out.println();

        return;
    }

    // remove one GC from the entry list,
    // then for each RR from the taken GC
    //     put RR in the combinations list,
    //     call recursion
    //     the remove RR from the combinations list
    // end for each
    // then put GC back into its list

    Map.Entry<GC, List<RR>> entry = mapEntryList.remove(0);

    List<RR> entryValue = new ArrayList<RR>(entry.getValue());

    while (!entryValue.isEmpty()) {

        RR rr = entryValue.remove(0);

        combinations.add(rr);

        doRecursion(mapEntryList, combinations);

        combinations.remove(combinations.size() - 1);
    }

    mapEntryList.add(0, entry);
}