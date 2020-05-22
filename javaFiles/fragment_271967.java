Random r = new Random();
int randomNumber = r.nextInt(100-1) + 1; // we will have 100 objects 

switch(randomNumber) {
    case 1:
        drawChair();
        break;
    case 2:
        drawTV();
        break;
    ...
    case 100: 
        drawSofa();
        break;
}