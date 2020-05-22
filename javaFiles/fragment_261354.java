float a1 = 0;
float a2 = 0;
float sizecircle = 250;
void draw() {
    background (51, 51, 51);

    for (float i = 0; i < TWO_PI; i += TWO_PI/100) {  
        line (350 + sin(a1+i)*sizecircle, 275 + cos(a1+i)*sizecircle,
              450 + cos(a2+i)*sizecircle, 375 + sin(a2+i)*sizecircle);
    }

    a1 += 0.006;
    a2 += 0.002;
}