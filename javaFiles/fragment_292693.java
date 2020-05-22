String str = "1234-5678-9101";

char[] chars = {'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};
StringBuilder builder = new StringBuilder();

for (int i = 0; i < str.length(); ++i) {
    if (Character.isDigit(str.charAt(i))) {
        builder.append(Chars[(int)(str.charAt(i))-48]);
    } else {
        builder.append("\u202A");
        builder.append(str.charAt(i));
    }
}