StringBuilder result = new StringBuilder();
for (char c  : editText.getText().toString().toCharArray())
    if (Character.isLetter(c))
        result.append(c);
    else break;

String code = result.toString();