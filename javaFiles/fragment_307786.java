boolean used[] = new boolean[30];
int i;

do {
    Random r = new Random();
    i=r.nextInt(4);

} while(used[i] == true);

String quest=question[i];
used[i] = true;