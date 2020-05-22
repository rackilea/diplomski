public static void main(String[] args) {
        String toParse = "<img style=\"-webkit-user-select: none;\" src=\"http://localhost:8080/dashboardmanager/downloadfile?entityId=4886\">";    
        String delimiter = "src=\"";
        int index = toParse.indexOf(delimiter) + delimiter.length();
        System.out.println(toParse.substring(index, toParse.length()).split("\"")[0]);      
    }