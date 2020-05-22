String[] turn1 = idList.split(","); 
String[] turn2 = labelList.split(","); 
List<Attribute> Temp = new ArrayList<Attribute>(); 

for(int i=0;i<turn1.length;i++){ 
    long getId;
    Attribute attribute = new Attribute(); 
    getId = Integer.parseInt(turn1[i]); 
    attribute.setId(getId); 
    attribute.setLabel(turn2[i]); 
    Temp.add(attribute); 
} 

for(int i=0;i<3;i++) 
System.out.println(Temp.get(i));