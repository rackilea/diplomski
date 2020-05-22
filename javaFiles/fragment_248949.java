queryMarkerTransformation(int markerId);
Returns float array with 16 values. The values represent an OpenGL style transformation matrix.
The first 4 values represent the first column of the matrix.

i.e:
float[16] = [0.24218401, 0.9598883, 0.14125957, 0.0, -0.8614648, 0.2801126, -0.42357886, 0.0, -0.44614935, -0.019116696, 0.8947546, 0.0, 23.678268, -6.4265084, -298.65326, 1.0]

The matrix looks like:
0.24218401  -0.8614648  -0.44614935     23.678268
0.9598883   0.2801126   -0.019116696    -6.4265084
0.14125957  -0.42357886 0.8947546       -298.65326
0.0         0.0         0.0             1.0

The last column represents x,y,z in the camera coordinate system.