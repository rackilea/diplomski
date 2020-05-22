batch.setShader(grayscaleShader);
batch.begin();
grayscaleShader.setUniformf("u_grayness", grayness);
//draw stuff
batch.end();
batch.setShader(null);