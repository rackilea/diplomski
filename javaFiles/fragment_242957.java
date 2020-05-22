int fontStyle = 0;
if (style.equals("bolditalic")) {
    fontStyle = Font.BOLD | Font.ITALIC;
} else if (style.equals("italic")) {
    fontStyle = Font.ITALIC;
} else if (style.equals("bold")) {
    fontStyle = Font.BOLD;
} else if (style.equals("plain")) {
    fontStyle = Font.PLAIN;
}