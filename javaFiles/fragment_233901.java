#version 430    
layout (location = POSITION) in vec2 position;

layout (binding = TRANSFORM) uniform Transform
{
    mat4 mat;
};

void main(void)
{    
    gl_Position = mat * vec4(position, 0, 1);
}