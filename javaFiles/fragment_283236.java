if(cbxRandom.isSelected())
{
    double[] num = new double[10];
    String newtxt = "";
    for(int i=0; i<10; i++)
    {
        Random r = new Random();
        num[i] = r.rnd;
        newtxt += String.valueOf(num[i]);
    }
    txtValor.setText(newtxt); //do setting only after the loop ends
}