StringBuffer b = new StringBuffer();
for (int i = 0; i < p.length(); ++i) {
    char ch = p.charAt(i);
    if (ch > 0) {
        b.append(ch);
    }
}

System.out.println(b.toString());