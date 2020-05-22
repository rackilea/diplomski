if (e.getSource() == sortButton)
    {
        ReadFile r;
        try
        {
            r = new ReadFile(field.getText());
            r.readAndSortFile();

            WriteFile w = new WriteFile(field.getText());
            w.writeFile(r.getList());

        } 
        catch (FileNotFoundException e1)
        {
            field.setText(e1.getMessage());
            e1.printStackTrace();
        }       
    }