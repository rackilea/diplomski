#version 400

in TGeometryData
{
    vec3  linePos;
    vec3  lineMidPoint;
    float lineLen;
} inData;

out vec4 fragColor;

uniform float u_dashLen;
uniform float u_gapLen;
uniform vec4  u_color;

void main()
{
    float midDist  = length( inData.linePos - inData.lineMidPoint ); 
    float modDist  = mod( midDist + u_dashLen * 0.5, u_dashLen + u_gapLen );
    float onDash   = max( step( modDist, u_dashLen ), 
                          step( inData.lineLen * 0.5 - u_dashLen, midDist ) );
    if ( onDash < 0.5 )
        discard;
    fragColor      = u_color * onDash;
}