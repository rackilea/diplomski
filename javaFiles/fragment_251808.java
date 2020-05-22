for (int i = 0; i <= text.length(); i++) {
    switch (Character.toLowerCase(text.charAt(i))) {
        case 'a':
            acountA++;
            break;
        case 'b':
            acountB++;
            break;
        default:
            break;
    }
}