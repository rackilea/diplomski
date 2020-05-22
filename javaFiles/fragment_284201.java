void getClass(String command, char* returnStr) {
    for (int i = 0; i < 3; i++) {
        returnStr[i] = command[i+1];
    }

    return returnStr;
}

// Usage
char returnStr[3];
getClass(UsartString, returnStr);
Serial.println(returnStr);