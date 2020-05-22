String sum="";
int input = Integer.parseInt(value.getText().toString());
for (int i = 0; i < 10; i++)
{
    sum += i + input + "\n";
}
display.setText(sum);