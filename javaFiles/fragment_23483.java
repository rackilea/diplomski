#version 120

uniform vec4 objectColor; // Color of the object you are drawing
varying vec3 normal;
varying vec4 position;

void main( void )
{
    // Use glDrawBuffers to configure multiple render targets
    gl_FragData[0] = objectColor; // Diffuse
    gl_FragData[1] = vec4(normalize(normals.xyz), 0.0); // normals
    gl_FragData[2] = vec4(position.xyz, 0.0); // Position
}