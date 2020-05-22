public class Slot {

boolean v;
short block[];

public Slot(int byteSize){
valid = false;

//Instantiate each element in block[] to 0
block = new short[byteSize];
for(int i = 0; i < block.length; i++){
    block[i] = 0;
}
}