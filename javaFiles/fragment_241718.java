Set<String> fromInt = new HashSet<>();
try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    for(String line; (line = br.readLine()) != null;)
        fromIn.add(normalise(line));
}
// compare argsList with fromIn.