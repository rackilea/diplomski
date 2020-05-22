public class C {
int slotNum;
Slot[] s;


public C(int byteSize, int slotNum){
this.slotNum = slotNum;

s = new Slot[slotNum]; //create an array of slots

for(int i = 0; i < slotNum; i++){ //for every slot and instantiate
    s[i] = new Slot(byteSize); 
}
display();
}