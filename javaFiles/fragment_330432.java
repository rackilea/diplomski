int prevId = 0;
for (CSVRecord record : records) {
    id = record.get(0);
    target = record.get(1);
    if(id == preId+1){
        System.out.println(id + " " + target);
        prevId = id;
    }else if(id > prevId+1){
        prevId++;
        for(; prevId < id; prevId++){
            System.out.println(prevId + " no target");
        }
        System.out.println(id + " " + target);
        prevId = id;
    }
}