int uniques = 0;
for (int i = 0; i <= 127; i++) {
    s = Character.toString((char) i);
    if (str.contains(s)) {
        ++uniques;
    }
}
return str.length() == uniques;