for (int index = word.indexOf(guess);
     index >= 0;
     index = word.indexOf(guess, index + 1))
{
    System.out.println(index);
}