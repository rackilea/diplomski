varying vec3 normal;
varying vec2 texcoord0;
varying vec3 fragPos;

uniform sampler2D u_texture;
uniform vec3 lightPos;
uniform vec3 lightColor;

void main()
{
    vec3 color = texture(u_texture, texcoord0).rgb;

    // Ambient
    float ambientStrength = 0.1;
    vec3 ambient = ambientStrength * lightColor;

    // Diffuse
    vec3 norm = normalize(normal);
    vec3 lightDir = normalize(lightPos - fragPos);
    float diff = max(dot(norm, lightDir), 0.0);
    vec3 diffuse = diff * lightColor;

    //vec3 result = (ambient + diffuse) * color;
    vec3 result = color;
    gl_FragColor = vec4(result, 1.0);
}