vec3 ReconstructNormal(vec3 positionWorldSpace) 
{
    vec3 normalViewSpace = normalize(cross(dFdx(positionWorldSpace), dFdy(positionWorldSpace)));
    vec3 normalWorldSpace = (vec4(normalViewSpace, 0.0) * viewMatrix).xyz;
    return normalWorldSpace;
}