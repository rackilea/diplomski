InputStream in = getClass().getClassLoader().getResourceAsStream("html/index.html");
Scanner scanner = new Scanner(in);
StringBuffer buffer = new StringBuffer();
while(scanner.hasNextLine()) {
    buffer.append(scanner.nextLine());
}

browser.setText(buffer.toString());