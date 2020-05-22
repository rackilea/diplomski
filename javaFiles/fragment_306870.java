void test1() { 
    char buf[64];
    double start,x;
    int i;
    start = 1.0;
    x = start;
    for(i=0;i<367;i++) {
        printf("%s\n",sprintfDouble5(buf,x));
        x *= -7.0;
    }
    x = start;
    for(i=0;i<6;i++) {
        printf("%s\n",sprintfDouble5(buf,x));
        x /= -5;
    }
    for(i=0;i<200;i++) {
        printf("%s\n",sprintfDouble5(buf,x));
        x/= -42.01;
    }
    x = atan(1.0) * 4 * 0.0000001; /* PI */
    for(i=0;i<20;i++) {
        printf("%s\n",sprintfDouble5(buf,x));
        x *= 10;
    }
    printf("%s\n",sprintfDouble5(buf,0.0));
    printf("%s\n",sprintfDouble5(buf,-0.0));
    printf("%s\n",sprintfDouble5(buf,0.0/0.0));
}