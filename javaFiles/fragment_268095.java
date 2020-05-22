else if(operations == "^")
{
    result = Math.pow(firstnum, secondnum);
    answer = String.format("%.2f", result);
    tfdDisplay.setText(answer);
}