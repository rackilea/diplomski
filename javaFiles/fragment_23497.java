public  Integer generateLastFiveSequenceNumbers()
{
    Random ranndomNumber = new Random();
    int result = 0;
    for(int i = 0; i < 5; i++) {
        result = result * 10 + (randomNumber.nextInt(9) + 1);
    }
    return result;
}