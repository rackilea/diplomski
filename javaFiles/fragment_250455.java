// Will determine the starting index of the 4 specific characters (or -1)
int getIndex(char buf[]) {

    char c4='z';
    char c3='y';
    char c2='x';
    char c1='w';

    int tail = 3;
    while (tail < buf.length) {
        if (buf[tail] == c4 && buf[tail-1] == c3 && buf[tail-2] == c2 && buf[tail-3] == c1)
            return tail-3;
        tail++;
    }
    return -1;
}