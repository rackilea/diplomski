default:
    if (chars[counter] < ' ' || chars[counter] > 127) {
        if (counter > last) {
            super.output(chars, last, counter - last);
        }
        last = counter + 1;
        // If the character is outside of ascii, write the
        // numeric value.
        output("&#");
        output(String.valueOf((int)chars[counter]));
        output(";");
    }
    break;
}