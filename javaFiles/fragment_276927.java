int i = 0;
int yourValue = -1;

while (true)
{
    if (numOfDays > i) System.out.print("(" + i + ") " + total+ "   ");
    total = total * 0.9;
    if (total <= 20) {
        if (numOfDays > i) System.out.print("\nBecause mark drops below 20, mark stays as 20. final mark="+ finalMark);
        break;
    }
    if (total < 40 && yourValue == -1) yourValue = i;
    i++;
}
System.out.print("\nThis work can be up to " + yourValue + " days late before failing.");