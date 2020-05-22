List<String> list = new ArrayList<String>();
for (i=0 ; i < l ; i++) {
    LATIT = Double.parseDouble(data_array [i][2]);
    LONGIT = Double.parseDouble(data_array [i][3]); 

    dist = calculateDistanceByHaversineFormula(Localizacion.LONGITUD_D, Localizacion.data_arrayUD_D,LONGIT,  LATIT);

    if (dist < UMB1){

        list.add(data_array [i][0]);
                System.out.println(list);
                System.out.println(list.get(i));

     }

}