String[] tokens = input.split(" ");
StringJoiner joiner = new StringJoiner(" ");
for(String s : tokens) {
    if(!toFilter.contains(s) || seen.add(s)) {
        joiner.add(s);
    }
}

String result = joiner.toString();