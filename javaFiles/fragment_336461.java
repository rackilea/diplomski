for(int i=0; i<3; i++ )
{
    vec2 pos = vec2(x, y) * float(i);
    float dist = distance(gl_FragCoord.xy, pos);

    alpha = smoothstep(50.0, 100.0, dist);
    totalDiffuse += clamp(1.0-alpha, 0.0, 1.0) * lightColor;
}