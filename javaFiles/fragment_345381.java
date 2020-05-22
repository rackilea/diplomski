#version 400

layout( lines_adjacency ) in;
layout( triangle_strip, max_vertices = 4 ) out;

in TVertexData
{
    vec3 pos;
} inData[];

out TGeometryData
{
    vec3  linePos;
    vec3  lineMidPoint;
    float lineLen;
} outData;

uniform float u_thickness;

void main()
{
    if ( gl_InvocationID != 0 )
        return;

    vec3 pos0    = inData[1].pos;
    vec3 pos1    = inData[2].pos;
    vec3 dirPred = normalize( inData[0].pos - pos0 );
    vec3 dirSucc = normalize( inData[3].pos - pos1 );
    vec3 dirLine = normalize( pos1 - pos0 ); 
    vec3 dirNorm = normalize( dirPred - dirLine * dot(dirLine, dirPred) );
    dirSucc = faceforward( dirSucc, -dirNorm, dirSucc );

    vec3 dir0 = abs( dot(dirPred, dirLine) ) > 0.99 ? dirNorm : normalize( dirPred + dirLine );
    vec3 dir1 = abs( dot(dirSucc, dirLine) ) > 0.99 ? dirNorm : normalize( dirSucc - dirLine );

    vec3 pos01 = pos0 + dir0 * u_thickness / dot(dir0, dirNorm);
    vec3 pos11 = pos1 + dir1 * u_thickness / dot(dir1, dirNorm);

    vec3 lineMidPoint0 = (pos0 + pos1) * 0.5;
    vec3 lineMidPoint1 = lineMidPoint0 + dirNorm * u_thickness;

    outData.lineLen = length( pos1 - pos0 );

    outData.lineMidPoint = lineMidPoint0; 
    outData.linePos = pos0;
    gl_Position = vec4(pos0, 1.0); EmitVertex();
    outData.linePos = pos1;
    gl_Position = vec4(pos1, 1.0); EmitVertex();

    outData. lineMidPoint = lineMidPoint1; 
    outData.linePos = pos01;
    gl_Position = vec4(pos01, 1.0); EmitVertex();
    outData.linePos = pos11;
    gl_Position = vec4(pos11, 1.0); EmitVertex();

    EndPrimitive();
}