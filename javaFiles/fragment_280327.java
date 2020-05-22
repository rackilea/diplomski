public void setUp()
{
    Levels Levels = new Levels();

    String HText = "";
    int CorrectAnswer = Integer.parseInt(Levels.CorrectAnswer);
    int Question1 = Integer.parseInt(Levels.Question1);
    int Remaining = CorrectAnswer - Question1;

    Log.d("setUp", "CorrectAnswer: " + CorrectAnswer + "\n"
            + "Question1: " + Question1 + "\n" + "Remaining: " + Remaining);

    TextView TVHint = (TextView) findViewById(R.id.hint);
    while (Remaining != 0)
    {
        Log.d("setUp", "Remaining: " + Remaining);
        if (Remaining >= 100)
        {
            Remaining = Remaining - 100;
            Log.d("setUp", "Remaining - 100: " + Remaining);

            if (HText != "")
            {
                HText = HText + " + " + "100";
            }
            else
            {
                HText = "100";
            }
        }
        else
        {
            if (Remaining >= 10)
            {
                Remaining = Remaining - 10;
                Log.d("setUp", "Remaining - 10: " + Remaining);

                if (HText != "")
                {
                    HText = HText + " + " + "10";
                }
                else
                {
                    HText = "10";
                }
            }
            else
            {
                if (Remaining >= 5)
                {
                    Remaining = Remaining - 5;
                    Log.d("setUp", "Remaining - 5: " + Remaining);

                    if (HText != "")
                    {
                        HText = HText + " + " + "5";
                    }
                    else
                    {
                        HText = "5";
                    }
                }
                else
                {
                    if (Remaining >= 1)
                    {
                        Remaining--;
                        Log.d("setUp", "Remaining - 1: " + Remaining);

                        if (HText != "")
                        {
                            HText = HText + " + " + "1";
                        }
                        else
                        {
                            HText = "1";
                        }
                    }
                }
            }
        }
        Log.d("setUp", "HText: " + HText);
    }
    TVHint.setText(HText);
}