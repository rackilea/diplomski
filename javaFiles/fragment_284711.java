attribute vec3 a_position;
attribute vec3 a_normal;
attribute vec3 a_texCoord0;
uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;

varying vec3 fragPos;
varying vec3 normal;
varying vec2 texcoord0;

void main()
{
    gl_Position = projection * view * model * vec4(a_position, 1.0);
    fragPos = vec3(model * vec4(a_position, 1.0));
    normal = a_normal;
    texcoord0 = a_texCoord0;
}