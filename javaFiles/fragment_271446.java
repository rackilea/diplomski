#version 300 es

precision mediump float;

uniform sampler2D originalTexture;
uniform sampler2D blurTexture;

in vec2 texCoord;

void main()
{
    vec4 originalColor = texture(originalTexture, texCoord);
    vec4 blurColor     = texture(blurTexture,     texCoord);
    gl_FragColor = originalColor+blurColor;
}