int statistics[]=new int[65536];
int onechar;
while(-1!=(onechar=br.read())){
    statistics[onechar]++;
}

for(int i=' ';i<statistics.length;i++){
    if(statistics[i]>0){
        System.out.println(String.format("%c: %d",i,statistics[i]));
    }
}