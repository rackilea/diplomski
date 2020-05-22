List<String>[] results = new List[order.length];
    LinkedList<String> remainders = new LinkedList<String>();

    for (String word : displaylist) {
        boolean found = false;
        for(int i=0; i<order.length; i++) {
            if(word.contains(order[i])) {
                if(results[i] == null) results[i] = new LinkedList<String>();
                results[i].add(word);
                found = true;
                break;
            }
        }

        if( !found ) {
            remainders.add(word);
        }
    }

    List<String>theResult = new ArrayList<String>(displaylist.length);
    for ( List<String>result : results) {
        if( result != null ) theResult.addAll(result);
    }

    theResult.addAll(remainders);