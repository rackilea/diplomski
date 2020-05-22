int totalRecords = 10;
int pageCounter=0;
int rowsCounter=3;
for(int i=0;i<totalRecords;i++){
    if(i%rowsCounter==0){
        pageCounter++;
    }
    System.out.println("Record :"+i+" on Page:"+pageCounter);
}