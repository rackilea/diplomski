try (BufferedReader br = new BufferedReader(new FileReader(convertedFile))) 
{ 
    List<String> str= new ArrayList<>();
    String line = ""; 
    while ((line = br.readLine()) != null) { 
    str.add(line.split(" "));
    } 
} 
catch (FileNotFoundException e) { 
 System.out.println(e.getMessage());
} catch (IOException e){ 
 System.out.println(e.getMessage()); 
}