// simulate 3D surface
vec2 new_coord = v_texCoord0;
// calculate the stretching factor
float factor = ((0.5 - new_coord.x) * new_coord.y);
// apply the factor and stretch the image
new_coord.x += factor;

gl_FragColor = texture2D(u_texture, new_coord);