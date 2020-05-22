out vec4 passColor; // passed out to the frag shader
out vec2 passTexCoord;  // passed out to the frag shader

void main() {
    // gl_Poisition is still in the core profile
    gl_Position = projectionMatrix * viewMatrix * modelMatrix * inPosition;

    // need to be passed
    passColor = inColor;
    passTexCoord  = inTexCoord;
}