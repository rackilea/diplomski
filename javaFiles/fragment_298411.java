// 'a'=97, 'z'=122
Random r = new Random();
StringBuilder randomString = new StringBuilder();
for (int i = 0; i < le; ++i) {
    int j = 97 + r.nextInt(122-97);
    char c = (char) j;
    randomString.append(c);
}
randomString.toString();