List<String> l = new ArrayList<>();

        l.add("0 CC");
        l.add("1 BB");
        l.add("2 AA");
        l.add("3 AA");

    String str="";
    for(String s: l){
        str+=s+",";
    }
    String[] sArr = str.split(",");
    String temp="";
    for(int i=0; i<sArr.length;i++) {
        for(int j= i+1; j<sArr.length;j++){
            if(sArr[i].split("\\s")[1].compareToIgnoreCase(sArr[j].split("\\s")[1])>0){
                temp= sArr[j];
                sArr[j]= sArr[i];
                sArr[i]=temp;
            }
        }
    }
    for(String g: sArr){
        System.out.println(g);
    }

output:
2 AA
3 AA
1 BB
0 CC