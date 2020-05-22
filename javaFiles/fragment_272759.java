void main()
{
    v_color = a_color;
    v_texCoords = a_texCoord0;
    vec4 screenSpacePosition = u_projTrans * a_position;
    gl_Position =  screenSpacePosition;

    v_lightCoords = (screenSpacePosition.xy * u_zoom) * 0.5 + 0.5;
}