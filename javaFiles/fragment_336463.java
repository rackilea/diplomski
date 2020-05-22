<script id="draw-shader-vs" type="x-shader/x-vertex">
precision mediump float;
attribute vec2 inPos;

void main() {
    gl_Position = vec4( inPos.xy, 0.0, 1.0 );
}
</script>

<script id="draw-shader-fs" type="x-shader/x-fragment">
precision mediump float;
uniform float u_time;
uniform vec2 u_resolution;

vec3 HUEtoRGB(in float H)
{
    float R = abs(H * 6.0 - 3.0) - 1.0;
    float G = 2.0 - abs(H * 6.0 - 2.0);
    float B = 2.0 - abs(H * 6.0 - 4.0);
    return clamp( vec3(R,G,B), 0.0, 1.0 );
}

void main() {
    vec2 uv = gl_FragCoord.xy / u_resolution;

    vec3 lightColor = vec3(1, 1, 1);
    float range = length(u_resolution) / 4.0;
    float x = u_resolution.x / 4.0;
    float y = u_resolution.y / 4.0;
    float ambient = 0.1;
    float intensity = 0.8;
    float alpha = 1.0;

    vec3 totalDiffuse = vec3(0.0);

    for(int i=0;i<3;i++)
    {    
        vec2 pos = vec2(x, y) * float(i+1);
        float dist = distance(gl_FragCoord.xy, pos);
        
        alpha = smoothstep(range/4.0, range/2.0, dist);
        totalDiffuse += clamp(1.0-alpha, 0.0, 1.0) * lightColor;
    }
    totalDiffuse = max(totalDiffuse, ambient);

    vec4 texcol = vec4( 1.0-uv.x, 1.0-uv.y, uv.x*uv.y, 1.0 );
    gl_FragColor = vec4(totalDiffuse, 1.0) * texcol;
}
</script>

<canvas id="ogl-canvas" style="border: none"></canvas>