Map<String, ArrayList<String>> hashMap = new HashMap();

int checkpoint = 0;
int i = 0;
List<String> keys1 = new ArrayList<String>();
List<String> keys2 = new ArrayList<String>();
List<String> keys3 = new ArrayList<String>();

while(it.hasNext()) {
    line = it.nextLine();

    if (line.contains('checkpoint1')) {
        checkpoint = 1;
    } else if (line.contains('checkpoint2')) {
        checkpoint = 2;
    } else if (line.contains('checkpoint3')) {
        checkpoint = 3;
    } else {
        switch (checkpoint) {
            case 0: 
                    keys1.add(line);
                    break;
            case 1: 
                    List<String> values = new ArrayList<String>();
                    values.add(line);
                    hashMap.put(keys1.get(i++),values);
                    break;
            case 2: 
                    keys2.add(line);
                    break;
            case 3: 
                    keys3.add(line);
                    break;
        }
    }
}

for (String k: keys2){
    hashMap.put(k,keys3);
}