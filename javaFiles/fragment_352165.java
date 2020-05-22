unitValue = Double.parseDouble(tfUnit.getText());
valMeter = unitValue * factor(unit);
labelDesc.setText(unit);
convert();

Number factor(String unitName)
{
     switch(unitName)
     {
         case "Unit 1": return defined1;
         case "Unit 2": return defined2;
         default: throw new Exception("Unknown unit");
     }
}