// p, q, and r are triangle vertices and are of the form {x, y, z}.
public void make_triangle(float[] p, float[] q, float[] r)
{
    Object3D triangle = new Object3D();

    // Copy three points into a flat array as our vertices.
    float[] vertices = new float[3 * 3];
    for (int i = 0; i < 3; i++) {
        vertices[i] = p[i];
        vertices[3 + i] = q[i];
        vertices[6 + i] = r[i];
    }

    // Set up index buffer to point at our three vertices and thus draw one triangle.
    int[] indices = new int[3];
    for (int i = 0; i < 3; i++) {
        indices[i] = i;
    }

    // Set up the rendering data.
    triangle.setData(vertices, null, null, null, indices, true);

    // Render the triangle double sided.
    triangle.setDoubleSided(true);

    // Use a blue material.
    Material material = new Material();
    material.setColor(Color.BLUE);
    triangle.setMaterial(material);

    // Add the triangle to the current scene.
    getCurrentScene().addChild(triangle);
}