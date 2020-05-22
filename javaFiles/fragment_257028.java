StringBuilder sb = new StringBuilder(quote.length());
for (int index = 0; index < quote.length(); index++) {
    if (quote.charAt(index) == '"') {
        System.out.println(sb);
        sb.delete(0, sb.length());
    } else {
        sb.append(quote.charAt(index));
    }
}