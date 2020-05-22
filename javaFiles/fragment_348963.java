attribute vec3 a_posL;
uniform mat4 u_mvpMatrix;
void main()
{
    gl_Position = u_mvpMatrix*vec4(a_posL,1.0);
}