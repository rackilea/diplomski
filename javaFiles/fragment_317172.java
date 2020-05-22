int i = -1;
int j = -1;
while(!found && ++i < row) {
    j = -1;
    while(!found && ++j < column) {
        found = (arr[i][j] == check);
    }
}