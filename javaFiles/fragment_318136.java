public static void Func( List<Place> places, int index, Deque<Integer> tokens) {
    if (index == places.size()) {
        // if control reaches here, it means that we've recursed through a particular combination
        // ( consisting of exactly 1 token from each place ), and there are no more "places" left
        String outputTokens = "";
        for (int token : tokens) {
            outputTokens += token + ",";
        }
        System.out.println("Tokens: "+outputTokens);
    } else {
        Place p = places.get(index);
        for (int token : p.tokens) {
            tokens.addLast(token);
            Func(places, index+1, tokens);
            token.removeLast();
        }
    }
}