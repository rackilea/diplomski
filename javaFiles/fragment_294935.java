NumberFormat format = NumberFormat.getInstance(Locale.FRENCH);
Number number = format.parse(input_row.prix2);
double d = number.doubleValue();

output_row.nom = input_row.nom;
output_row.code = input_row.code;
output_row.date = input_row.date;
output_row.ref = input_row.ref;
output_row.ean = input_row.ean;
output_row.quantitie = input_row.quantitie;
output_row.prix1 = input_row.prix1;
output_row.prix2 = d;