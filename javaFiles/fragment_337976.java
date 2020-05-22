ButtonObject[] enemies = new ButtonObject[10];
for (int i = 0; i < 10; i++)
{
    String text = String.valueOf(i);
    int y = 300 - (i * 55);
    enemies[i] = new ButtonObject(text, 16, y, 40, 55);
}