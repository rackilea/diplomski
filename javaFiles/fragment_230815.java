String[] test = {
     "some-string-test-moretext.csv",
     "another-string-test-andthensome.csv"
};
for (String s: test) {
    System.out.println(s.split("-")[2]);
}