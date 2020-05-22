public void calculateSizes() {
//if you assign these values to variables it will be much better and you wont need to compute it all the time    
firstBox.calcVolume();
secondBox.calcVolume();


message = "\n ";
if (secondBox.calcVolume() > firstBox.calcVolume() &&  secondBox.calcVolume() / firstBox.calcVolume() > 4 ) {  
    message += ("Box two is " + (secondBox.calcVolume() / firstBox.calcVolume()) + " times the size first box");
} else if (firstBox.calcVolume() > secondBox.calcVolume() &&  firstBox.calcVolume() / secondBox.calcVolume() > 4 ) {  
    message += ("Box one is " + (firstBox.calcVolume() / secondBox.calcVolume()) + " times the size second box" ); 
} else if (firstBox.calcVolume() == secondBox.calcVolume()) { 
    message += ("The first box is the same size as the second box");
} else if (secondBox.calcVolume() >= firstBox.calcVolume() / 4) {
    message += ("The second box is quadruple the size than the first box");
} else if (firstBox.calcVolume() >= secondBox.calcVolume() / 4) {
    message += ("The first box is quadruple the size than the second box");
} else if (firstBox.calcVolume() >= secondBox.calcVolume() / 3) {
    message += ("The first box is triple the size than the second box");
} else if (secondBox.calcVolume() >= firstBox.calcVolume() / 3) {
    message += ("The second box is triple the size than the first box");
} else if (firstBox.calcVolume() >= secondBox.calcVolume() / 2) {
    message += ("The first box is twice the size than the second box");
} else if (secondBox.calcVolume() >= firstBox.calcVolume() / 2) {
    message += ("The second box is twice the size than the first box");
} else if (firstBox.calcVolume() > secondBox.calcVolume() ) {
    message += ("The first box is slightly bigger than the second box");
} 
 }