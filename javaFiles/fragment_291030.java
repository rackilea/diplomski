Stack<String> historyStack = new Stack<>();
Stack<String> forwardStack = new Stack<>();
String currentUrl = null;

boolean running = true;
while(running) {
    String input = getUserInput();
    switch(input) {
        case "quit":
            running = false;
            break;
        case "back":               
            if (!historyStack.empty()) {
                if (currentUrl != null) {
                    forwardUrl.push(currentUrl);
                }
                currentUrl = historyStack.pop();
                System.out.println(currentUrl);
            } else {
                System.out.println("nothing to go back to");
            }
            break;
        case "forward":
            if (!forwardStack.empty()) {
                if (currentUrl != null) {
                    historyStack.push(currentUrl);
                }
                currentUrl = forwardStack.pop();
                System.out.println(url);
            } else {
                System.out.println("nothing to go forward to");
            }
            break;
        default:
            if (currentUrl != null) {
                historyStack.push(currentUrl);
            }
            currentUrl = input;
            System.out.println(url);
            // entering a new url makes forward stack invalid
            forwardStack.clear();
    }
}