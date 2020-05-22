final String alphabet = "<Your special characters>";
final int N = alphabet.length();
Random rd = new Random();
int iLength = <length you want>;
StringBuilder sb = new StringBuilder(iLength);
for (int i = 0; i < iLength; i++) {
    sb.append(alphabet.charAt(rd.nextInt(N)));
}