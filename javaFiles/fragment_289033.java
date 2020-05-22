int j = i + 1;
int oldI = i;//this is so you save the old value
for (; j < in.length(); j++) {
    if (!Character.isDigit(in.charAt(j))) {
        break;
    }
    i++;
}
out.append(in.substring(oldI, j));
out.append(' ');