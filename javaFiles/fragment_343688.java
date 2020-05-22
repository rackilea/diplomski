for (tosses = 0; tosses < 1000; tosses ++)
{
    headsTails = (int) (Math.random() * 2) + 1;
    if (headsTails == 1) {
        heads ++;
    } else {
        tails ++;
    }
}