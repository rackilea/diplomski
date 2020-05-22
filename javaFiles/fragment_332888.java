int count = 10;
Item[] array = new Item[count];
int row = 0;
while(count > 0){   
    if (count <= 5) {
        array[row].id = variable1;
        array[row].description = variable2;
        row++;
    }                   
    count--;                    
}
for(row = 0; row < 5; row++){
    System.out.println("Item #: " + array[row].id + " Item Description: " + array[row].description);
}