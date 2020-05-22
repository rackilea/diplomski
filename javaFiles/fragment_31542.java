int counter = 0;
for (char ch : text.toCharArray())
    if (ch == '(') counter++;
    else if (ch == ')') counter--;

    if (counter < 0) break;
}
if (counter != 0) error();