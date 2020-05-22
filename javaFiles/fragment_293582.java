// Implementing Fisher–Yates shuffle
static void shuffleArray(CardGame[] ar)
{
  Random rnd = new Random();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
    // Simple swap
    CardGame a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
}