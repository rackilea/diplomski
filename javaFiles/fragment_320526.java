value1 = Double.parseDouble(maxValue1.getText());
value2 = Double.parseDouble(maxValue2.getText());

int length = (int) value1;
x = new double[length];

for(int i = 0; i < length; i++)
{
    System.out.println(i);
    x[i] = value2 + i;
    value2 ++;
}