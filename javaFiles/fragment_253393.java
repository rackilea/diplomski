try(BufferedReader br = new BufferedReader(new FileReader("paroolid.txt"))){
    for(String line; (line = br.readLine()) != null;){
        if(line.toLowerCase().contains(toSearchFor.toLowerCase())){
            System.out.println(line);
        }
    }
}catch(Exception e){
    e.printStackTrace();
}