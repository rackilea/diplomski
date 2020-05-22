if(e.getSource() == rP)
    {
        red++;
        jtf_red.setText("" + red);

        if (red < 255)
        {
            jtf_red.setText("" + 255);
        }
    }
    else if(e.getSource()  == rM)
    {
        red--;
        jtf_red.setText("" + red);

        if (red < 0)
        {
            jtf_red.setText("" + 0);

        }