Vector4f left_bottom_near_v4 = new Vector4f(
    left_bottom_near.x, left_bottom_near.y, left_bottom_near.z, 1.0f
);

Vector4f left_bottom_near_world_v4 = new Vector4f();
Matrix4f.transform(Matrix4f left, left_bottom_near_v4, left_bottom_near_world_v4);

Vector3f left_bottom_near_world = new Vector3f(
    left_bottom_near_world_v4 .x, left_bottom_near_world_v4 .y, left_bottom_near_world_v4 .z
);