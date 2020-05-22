class Heart {

    // ...

    void rotate(float theta){
        float[] r = new float[hold];

        for(int k = 0; k < hold; k++){
            r[k] = dist(w/2,h/2,pos[k][0],pos[0][k]);

            xOff = r[k] * cos(theta);
            yOff = r[k] * sin(theta);
            stroke(255);
            println(pos[k][0] + xOff);
            ellipse(pos[k][0] + xOff,pos[0][k] + yOff,15,15);
        }
    }
}