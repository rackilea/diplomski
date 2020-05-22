import java.text.DecimalFormat;

String stringLitersOfPetrol = "123.00";
System.out.println("string liters of petrol putting in preferences is "+stringLitersOfPetrol);
Float litersOfPetrol=Float.parseFloat(stringLitersOfPetrol);
DecimalFormat df = new DecimalFormat("0.00");
df.setMaximumFractionDigits(2);
stringLitersOfPetrol = df.format(litersOfPetrol);
System.out.println("liters of petrol before putting in editor : "+stringLitersOfPetrol);