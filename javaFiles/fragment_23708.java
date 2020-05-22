int numCoordinates = /*(get the number of coordinates by getting number of clicks after a certain action, etc.)*/
int[] xCords = new int[numCoordinates];
int[] yCords = new int[numCoordinates];


xCords[index] = e.getX();
yCords[index] = e.getY();
index++;

if(index > numCoordinates){
    index = 0;
    pEdicao.repaint();
}