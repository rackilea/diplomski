Iterator<String> i1 = processesOccupyingHugeMemory.iterator();

    TextView[] text = new TextView[processesOccupyingHugeMemory.size()];
    int i=0;
    while(i1.hasNext())
    {
        text[i] = new TextView(this);
        text[i].setText(i1.next());
        text[i].setAllCaps(true);
        text[i].setId(i);
        text[i].setLayoutParams(params);
        myLinearLayout.addView(text[i]);
        i++;
    }