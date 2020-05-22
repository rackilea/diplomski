final ArrayList<String> valuesList = new ArrayList<String>();
 for(int i = 0;i<response.getPropertyCount();i++){
        SoapObject dersListesi = (SoapObject)response.getProperty(i);
        for (int j = 0; j < dersListesi.getPropertyCount(); j++) {
            Object objectNames = dersListesi.getProperty(j);
            SoapObject ders_kodu = (SoapObject)objectNames;
            SoapObject ders_adi = (SoapObject)objectNames;          
            String dersKodu = ders_kodu.getProperty("dersKodu").toString();
            String dersAdi =  ders_adi.getProperty("dersAdi").toString();
            valuesList.add(dersKodu+ " " + dersAdi);             
        }
  ArrayAdapter<String> ad =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,valuesList);