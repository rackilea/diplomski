double numberOfSteps = 1000;
double stepSize = 2.0 * Math.PI / numberOfSteps; 
for(double i=0; i<numberOfSteps; i++){
    double theta = i * stepsize;
    pg.plot(12*Math.cos(8.0 * theta), theta);
}