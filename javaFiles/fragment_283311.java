try (Reader inputReader = 
        new InputStreamReader(
            TaQL.class.getResourceAsStream(input))) {

    BufferedReader in = new BufferedReader(inputReader);

    for (String line; (line = in.readLine()) != null;) {
        // do something with the line
    }
}