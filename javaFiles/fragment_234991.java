String[] persons = data.split("person[\\d]");
    HashMap<Integer, StringBuilder> outputMap = new HashMap<>();
    outputMap.put(0,new StringBuilder("Name | Age | Designation | Date | HomeTown"));
    for(int i=0;i<persons.length;i++) {
        if(persons[i].contains("<Name>")){
            outputMap.put(i + 1, new StringBuilder()
                    .append(persons[i].split("</*Name>")[1]).append("|")
                    .append(persons[i].split("</*Age>")[1]).append("|")
                    .append(persons[i].split("</*Designation>")[1]).append("|")
                    .append(persons[i].split("</*Date>")[1]).append("|")
                    .append(persons[i].split("</*Hometown>")[1]));
        }
    }
    Collection<StringBuilder> outputData = outputMap.values();
    for(StringBuilder output: outputData){
        System.out.println(output);
    }