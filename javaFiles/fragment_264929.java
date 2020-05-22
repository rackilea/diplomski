public boolean cautare(String a,int b){
    boolean check=true;
    for(int j=1;j<=perslist.length;j++)
{

    if(perslist[j].getNume().equals(a) && perslist[j].getPin()==b)