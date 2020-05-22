} else {
    char currentChar = queue[i][0];
    for (int j = i; j < rear; j++) {
        queue[j][0] = queue[j+1][0];
        queue[j][1] = queue[j+1][1];
    }
    queue[rear][0] = currentChar;
    queue[rear][1] = '0';
    i--;
}