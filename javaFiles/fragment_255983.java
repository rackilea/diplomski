double max, min; 
if (Math.random() > .5) { // adjust ratio of ranges here
    min = 0;
    max = .00000001;
} else {
    min = .00000001;
    max = 1;
}
double random = Math.random() * (max - min) + min;