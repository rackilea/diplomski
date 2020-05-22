public static HighestData ReadHighestScoreFile() throws IOException {  
    // your code here  
    // ...  
    HighestData data = new HighestData();  
    data.setName( name );  
    data.setHours( out.readInt() );  
    data.setMinutes( out.readInt() );  
    data.setSeconds( out.readInt() );  
    data.setClicks( out.readInt() );  
    // ...  
    return data;  
}