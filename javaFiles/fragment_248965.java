private Console console;

...
console = System.console();
...
if (confirm("Do you want to create the file.elt? (Y/N)")) {
    elements.createElements(file);
} else {
    System.out.println("There will be no file.elt created! .");
}
...

private boolean confirm(String message) {
    String answer = console.readLine(message);
    while (!answer.matches("[YyNn]")) {
        answer = console.readLine("Please, type Y or N.");
    }
    return "Y".equalsIgnoreCase(answer);
}