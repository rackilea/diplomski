Random r = new Random();
p[0]=0.2;
p[1]=0.4;
p[2]=0.15;
p[3]=0.25;

float myVal = r.nextFloat();
float probSum = 0.0;

for (int i = 0; i < p.length; p++) {
    probSum += p[i];
    if (myVal <= probSum) {
        return i;
    }
}
return p.length-1;