vec4 val = texture2D(tex, texCoord);
if (val.a > 0.5) {
    gl_FragColor = val;
} else {
    discard;
}