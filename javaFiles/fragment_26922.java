@Override
    protected void process(List<String> golferList)
    {
        for (int gIndex = 0; gIndex < golferList.size(); gIndex++)
        {
            textFieldRMLast.setText(golferList.get(gIndex));
            cards.show(panelCont, ROSTERMAINT); // Show roster maint card
        }
    }