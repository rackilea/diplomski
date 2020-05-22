String encrypted = null;
char passChars[] = password.toCharArray();
for (int i=0; i < passChars.length; i++) {
    passChars[i] += 17;
}
encrypted = new String(passChars);