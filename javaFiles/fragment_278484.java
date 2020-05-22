@FXML
private void addButtonClicked(MouseEvent event) 
{
    if(latText.getText().equals(""))
    {
        System.out.println("Lat Empty");
    }
    else if(longText.getText().equals(""))
    {
        System.out.println("Long Empty");
    }
    else
    {
        latVal = Double.parseDouble(latText.getText());
        longVal = Double.parseDouble(longText.getText());

        dataSource.add(new PinList(latText.getText(),longText.getText(),descriptionText.getText()));

        for(PinList p: dataSource)
        {
            System.out.print(p.getLatPin() + " " + p.getLongPin() + " " + p.getDescriptionPin() + "\n");
        }
    }
}