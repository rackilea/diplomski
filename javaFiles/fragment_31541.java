int counter = 0;
for (int i=0; i<text_length; i++) {
    if (text[i] == '(') counter++;
    else if (text[i] == ')') counter--;

    if (counter < 0) break;
}

if (counter != 0) error();