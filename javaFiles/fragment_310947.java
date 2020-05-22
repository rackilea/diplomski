try {
    BufferedReader csvReader = new BufferedReader(new FileReader("/data/csvread.txt"));
    // BufferedReader listReader = new BufferedReader(new FileReader("/data/list.txt"));
    String csvItem, listItem;
    int count =0;
    while((csvItem = csvReader.readLine()) != null){
        System.out.println("before second loop:"+csvItem);
        BufferedReader listReader = new BufferedReader(new FileReader("/data/list.txt"));
        while ((listItem = listReader.readLine())!= null) {
            System.out.println("list Item: "+listItem.toLowerCase().split("¬")[1]);
            System.out.println("csv Item: "+csvItem.toLowerCase());
            if(listItem.toLowerCase().split("¬")[1].contains(csvItem.toLowerCase())){
                    count++;
            }
         }
    }

}catch(Exception e){
        e.printStackTrace();
}