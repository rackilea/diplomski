#version 400

layout (location = 0) in vec3 inPos;

out TVertexData
{
    out vec3 pos;
} outData;

void main()
{
    outData.pos = inPos;
    gl_Position = vec4( inPos, 1.0 );
}