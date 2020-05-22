/* time and speed received from user. */
/* initialize distance */
distance = 0;
for (int i = 1; i <= time; i++)
{
    /* increment distance in each iteration */
    distance += speed;
    /* print as you progress */
    System.out.println(i + "\t" + distance);
}