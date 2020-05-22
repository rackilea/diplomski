BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(send.getInputStream()));  

String line;  
ArrayList<String>  output = new ArrayList<String>(); 

while ((line = bufferedReader.readLine()) != null){ 
  output.add(line); 
}