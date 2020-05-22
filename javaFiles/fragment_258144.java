double total = 0.0;
for (String k : word1.keySet()) {
    System.out.println(k + "\t" + word1.get(k));
    try {
        total += Double.valueOf(word1.get(k));
    }
    catch(Exception e) {
        // count the value as 0 if cannot convert to a double
    }
}