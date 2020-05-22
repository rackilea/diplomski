function writeMessage(message) {
    if (document && document.write) { // running in a web browser
        document.write(message);
    } else { // it will be Rhino
        print(message);
    }
}