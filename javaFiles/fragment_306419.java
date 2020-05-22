String alpha = "sce"; // odd letters
String beta = "fsu"; // even letters + 1
StringBuilder secret = new StringBuilder();
for (int i = 0; i < alpha.length() + beta.length(); ++i) {
    if (i % 2 == 1) {
        secret.append(alpha.charAt(i / 2);
    } else {
        secret.append((char)(beta.charAt(i / 2) - 1);
    }
}