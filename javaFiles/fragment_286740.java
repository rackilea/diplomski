public class Foo{

    public static void main(String[] args) throws Exception{

        List<String> csvRows = null;
        try(var reader = Files.lines(Paths.get("dataFile.csv"))){
            csvRows = reader.collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
        }

        if(csvRows != null){

            String json = csvToJson(csvRows);
            System.out.println(json);

        }

    }

    public static String csvToJson(List<String> csv){

        //remove empty lines
        //this will affect permanently the list. 
        //be careful if you want to use this list after executing this method
        csv.removeIf(e -> e.trim().isEmpty());

        //csv is empty or have declared only columns
        if(csv.size() <= 1){
            return "[]";
        }

        //get first line = columns names
        String[] columns = csv.get(0).split(",");

        //get all rows
        StringBuilder json = new StringBuilder("[\n");
        csv.subList(1, csv.size()) //substring without first row(columns)
            .stream()
            .map(e -> e.split(","))
            .filter(e -> e.length == columns.length) //values size should match with columns size
            .forEach(row -> {

                json.append("\t{\n");

                    for(int i = 0; i < columns.length; i++){
                        json.append("\t\t\"")
                            .append(columns[i])
                            .append("\" : \"")
                            .append(row[i])
                            .append("\",\n"); //comma-1
                    }

                    //replace comma-1 with \n
                    json.replace(json.lastIndexOf(","), json.length(), "\n");

                json.append("\t},"); //comma-2

            });

        //remove comma-2
        json.replace(json.lastIndexOf(","), json.length(), "");

        json.append("\n]");

        return json.toString();

    }

}