stack elementStack;

foreach(char in string) {
    if(string-from-char == "[code]") {
        elementStack.push("code");
        string-from-char = "";
    }

    if(string-from-char == "[/code]") {
        elementStack.popTo("code");
        string-from-char = "";
    }

    if(char == "\n" && !elementStack.contains("code")) {
        char = "<br/>\n";
    }
}