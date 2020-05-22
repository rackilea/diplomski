@Test
public void readpartValues() throws IOException {
    String fielData = "[Device|EEP_FEATUREKOI_HFS_Max|Kostia]\r\n" + 
            "--------------------------------\r\n" + 
            "Name(1) = partHeader_A01\r\n" + 
            "Value(1) = 0x10\r\n" + 
            "Desc(1) = (Address 0x000) Article No. / P.C.B No Byte 1\r\n" + 
            "Name(2) = partHeader_A02\r\n" + 
            "Value(2) = 0x9\r\n" + 
            "Desc(2) = (Address 0x001) Article No. / P.C.B No Byte 2\r\n" + 
            "Name(3) = partHeader_A03\r\n" + 
            "Value(3) = 0x95\r\n" + 
            "Desc(3) = (Address 0x002) Article No. / P.C.B No Byte 3\r\n" + 
            "Name(4) = partHeader_A04\r\n" + 
            "Value(4) = 0x38\r\n" + 
            "Desc(4) = (Address 0x003) Article No. / P.C.B No Byte 4\r\n" + 
            "----------------------------------\r\n" + 
            "Name(12) = AdrIctPcbTestDate_Day\r\n" + 
            "Value(12) = 0xFF\r\n" + 
            "Desc(12) = (Address 0x00B) Test Date : Day\r\n" + 
            "---------------------------------\r\n" + 
            "Name(13) = AdrIctPcbTestDate_Month\r\n" + 
            "Value(13) = 0xFF\r\n" + 
            "Desc(13) = (Address 0x00C) Test Date : Month\r\n" + 
            "---------------------------------\r\n" + 
            "Name(14) = AdrIctPcbTestTime_Hour\r\n" + 
            "Value(14) = 0xFF\r\n" + 
            "Desc(14) = (Address 0x00D) Test Time : Hour\r\n" + 
            "---------------------------------\r\n" + 
            "Name(15) = AdrIctPcbTesTime_Minute\r\n" + 
            "Value(15) = 0xFF\r\n" + 
            "Desc(15) = (Address 0x00E) Test Time : Minute";


    BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fielData.getBytes())));

    Map<String, List<String>> nameToValuesMap  = readValues(reader);
    reader.close();

    List<String> partHeaderValues = nameToValuesMap.get("partHeader");
    System.out.println("partHeader = " + partHeaderValues.toString());

    List<String> adrIctPcbTestTimeValues = nameToValuesMap.get("AdrIctPcbTestTime");
    System.out.println("AdrIctPcbTestTime = " + adrIctPcbTestTimeValues.toString());
}