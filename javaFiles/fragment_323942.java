char c = dataReceived.charAt(i);

if (c != '\n' && c != '\r')
    parseCommand = parseCommand + c;
else
    parseCommand = "";