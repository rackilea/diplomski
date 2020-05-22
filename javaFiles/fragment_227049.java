final double[] prices = {
    3.75, 4.00, 4.50, 3.50
};

...

double total = 0.0;

for(int i = 0; i < boxes.length; i++) {
    if(boxes[i].isSelected()) {
        total += prices[i];
    }
}