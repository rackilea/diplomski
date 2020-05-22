leftArrowBubble.setMaximumSize(new Dimension(500, 500));
JLabel tac = new JLabel();
tac.setMaximumSize(new Dimension(450, 450));
//tac.setPreferredSize(new Dimension(350, 50)); //<----------

final int maximumSize = 56;
String textWithSeparators = "";
final StringTokenizer textTokenizer
    = new StringTokenizer(str, " \t\n\r", true);

while (textTokenizer.hasMoreTokens()) {
    final String part = textTokenizer.nextToken();
    for (int beginIndex = 0; beginIndex < part.length();
         beginIndex += maximumSize)
        textWithSeparators += (beginIndex == 0 ? "" : " ")
            + part.substring(beginIndex,
                             Math.min(part.length(),
                                      beginIndex + maximumSize));
}

System.out.println(textWithSeparators);

tac.setText("<html><body style='width:350px;padding:15px;display:block;'>"
            + textWithSeparators + "</body></html>");