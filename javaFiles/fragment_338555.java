Mat gl = Mat.zeros(256, 256, CvType.CV_64F);
Mat glt = gl.clone();

for (int y = 0; y < img.rows(); y++) {
    for (int x = 0; x < img.cols()-1; x++) {

        int i = (int) img.get(y, x)[0];
        int j = (int) img.get(y, x + 1)[0];

        double[] count = gl.get(i, j);
        count[0]++;
        gl.put(i, j, count);
    }
}

Core.transpose(gl, glt);
Core.add(gl, glt, gl);
Scalar sum = Core.sumElems(gl);
Core.divide(gl, sum, gl);