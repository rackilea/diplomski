float aspectRatio = (float)Display.getWidth() / (float)Display.getHeight();

float y_scale = 1.0f / (float)Math.tan( Math.toRadians(FOV / 2.0) );
float x_scale = y_scale * aspectRatio;

float near_x = NEAR_PLANE * x_scale;
float near_y = NEAR_PLANE * y_scale;

float far_x = FAR_PLANE * x_scale;
float far_y = FAR_PLANE * y_scale;

Vector3f left_bottom_near  = new Vector3f(-near_x, -near_y, FAR_PLANE);
Vector3f right_bottom_near = new Vector3f( near_x, -near_y, FAR_PLANE);
Vector3f left_top_near     = new Vector3f(-near_x,  near_y, FAR_PLANE);
Vector3f right_top_near    = new Vector3f( near_x,  near_y, FAR_PLANE);

Vector3f left_bottom_far  = new Vector3f(-far_x, -far_y, FAR_PLANE);
Vector3f right_bottom_far = new Vector3f( far_x, -far_y, FAR_PLANE);
Vector3f left_top_far     = new Vector3f(-far_x,  far_y, FAR_PLANE);
Vector3f right_top_far    = new Vector3f( far_x,  far_y, FAR_PLANE);