for (int i = s.lastIndexOf(".") - 1; i > 0; i--) {
    if (Character.isAlphabetic(s.charAt(i))) {
        sb.append(s.charAt(i));
    } else {
        break;
    }
}