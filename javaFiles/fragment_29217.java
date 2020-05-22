public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String str = "{" + 
                "    \"streetSegment\": [" + 
                "        {" + 
                "            \"distance\": \"0.04\"," + 
                "            \"highway\": \"residential\"," + 
                "            \"name\": \"Swift\"," + 
                "            \"line\": \"-1.6720224 52.6251985,-1.6721061 52.6250432,-1.6721799,             52.6248908,-1.6721996 52.6247594\"," + 
                "            \"wayId\": \"76473524\"" + 
                "        }," + 
                "        {" + 
                "            \"distance\": \"0.05\"," + 
                "            \"highway\": \"residential\"," + 
                "            \"name\": \"Swift\"," + 
                "            \"line\": \"-1.6721799 52.6248908,-1.6723374 52.6248669,-1.6732035 52.6249774,-1.6734643 52.6249894\"," + 
                "            \"wayId\": \"76473523\"" + 
                "        }" + 
                "    ]" + 
                "}";
    // to simulate stream reader    
    InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(str.getBytes())); 

     BufferedReader streamReader = new BufferedReader(in); 

    StringBuilder buff = new StringBuilder();

    String inputStr;
    while ((inputStr = streamReader.readLine()) != null)
        buff.append(inputStr);


    ObjectMapper mapper = new ObjectMapper();

    Street mj = mapper.readValue(buff.toString(), Street.class);

        if(mj == null){
            System.err.println("null");
        }                
    }