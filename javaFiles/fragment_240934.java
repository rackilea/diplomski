for(String element : list) {
        StringTokenizer st = new StringTokenizer(element);

        if(!element.startsWith("PRINT")) {
            while(st.hasMoreTokens()) {
                tok = st.nextToken();
                tokens.add(tok);