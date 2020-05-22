uniform sampler2D diffuseBuffer;
uniform sampler2D positionBuffer;
uniform sampler2D normalBuffer;

uniform float lightRadius; // Radius of our point light
uniform vec3 lightPos; // Position of our point light
uniform vec4 lightColor; // Color of our light
uniform vec2 screensize; // screen resolution

void main()
{
    // VU for the current fragment
    vec2 uv = vec2(gl_FragCoord.x / screensize.x, gl_FragCoord.y / screensize.y);
    // Read data from our gbuffer (sent in as textures)
    vec4 diffuse_g = texture2D(diffuseBuffer, uv);
    vec4 position_g = texture2D(positionBuffer, uv);
    vec4 gnormal_g = texture2D(normalBuffer, uv);

    // Distance from the light center and the current pixel
    float distance = length(lightPos - position_g.xyz);

    // If the fragment is NOT affecter by the light we discard it!
    // PS : Don't kill me for using discard. This is for simplicity.
    if(distance > lightRadius) discard;

    // Calculate the intensity value this light will affect the fragment (Standard light stuff!)
    ... Use lightPos and position_g to calculate the light normal ..
    ... Do standard dot product of light normal and normal_g ...
    ... Just standard light stuff ...

    // Super simple attenuation placeholder
    float attenuation = 1.0 - (distance / lightRadius);

    gl_FragColor = diffuse_g * lightColor * attenuation * <multiplier from light calculation>;
}