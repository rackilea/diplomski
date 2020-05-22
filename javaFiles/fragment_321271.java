ArrayList<ArrayList> output = new ArrayList<ArrayList<String>>();

//Add 26 buckets
for (char letter = 'a'; letter <= 'z'; letter++) {
    output.add(new ArrayList<String>());
}

//add each string to the correct bucket
for (String s : list) {
    for (char letter = 'a'; letter <= 'z'; letter++) {
        if (s.startsWith(String.valueOf(letter))) {

            output.get(letter).add(s);
            //   Get the bucket    add the string
        }
    }
}