char* getClass(String command) {
    size_t length = 3;
    char* returnStr = (char*) malloc(length);
    for (int i = 0; i < length; i++) {
        returnStr[i] = command[i+1];
    }

    return returnStr;
}

// Usage
char* classStr = getClass(UsartString);
Serial.println(classStr);
free(classStr);