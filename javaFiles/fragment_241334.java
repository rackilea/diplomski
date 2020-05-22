import org.joml.*;
public class CubePositions {
  public static void main(String[] args) {
    /* Cuboid center position */
    float px = 10, py = 0, pz = 0;
    /* Euler angles around x, y and z */
    float ax = 0, ay = 0, az = (float) java.lang.Math.PI / 2.0f;
    /* Scale factor for x, y und z */
    float sx = 1, sy = 3, sz = 1;
    /* Build transformation matrix */
    Matrix4f m = new Matrix4f()
        .translate(px, py, pz) // <- translate to position
        .rotateXYZ(ax, ay, az) // <- rotation about x, then y, then z
        .scale(sx, sy, sz);    // <- scale
    /* Compute cube corners and print them */
    Vector3f[] corners = new Vector3f[8];
    for (int i = 0; i < corners.length; i++) {
      int x = i % 2 * 2 - 1;
      int y = i / 2 % 2 * 2 - 1;
      int z = i / 4 % 2 * 2 - 1;
      corners[i] = m.transformPosition(x, y, z, new Vector3f());
      System.out.println(String.format(
          "Corner (%+d, %+d, %+d) = %s",
          x, y, z, corners[i]));
    }
  }
}