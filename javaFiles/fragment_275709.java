String str = new Scanner(System.in).nextLine();
int size = 3;
List<String> res = new ArrayList<>();
for (int i = 0; i < str.length() - size + 1; i++) {
    res.add(str.substring(i, i + size));
}
System.out.println(res); // [hel, ell, llo]