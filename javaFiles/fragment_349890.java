@Override
    protected void onStart()
    {
        super.onStart();
        addText("FirstActivity - \"onStart\" durchlaufen\n");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        addText("FirstActivity -\"onResume\" durchlaufen\n");
    }

    ... (more methods) 


    void addText(final String text) {
        ausgabe += text;
        tvAnzeige.setText(ausgabe);
    }