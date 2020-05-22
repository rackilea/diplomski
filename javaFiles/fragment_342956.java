int[] numbers = new int[size-1];
for(int i = size ; i > 1; i--)
{
    int temphead = head;
    numbers[i] = stack.getpeople(temphead);
    temphead = stack.getBLink(temphead);
}