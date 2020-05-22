uniform mat4 transform_matrix;
uniform highp float radius;
uniform mediump vec2 axis;
uniform mediump vec2 axis_origin;
uniform highp float tex_size;

attribute vec2 texCoord;

varying vec2 texCoordVarying;
varying float shadeVarying;

mat4 rotationxy(float angle, vec2 axis);
mat4 translationThenRotationZ(float x, float y, float z, float angle);

void main()
{
    vec3 axisOrigin = vec3(axis_origin, radius);
    vec2 offsetTexCoord = texCoord - axis_origin;
    float angle = dot(offsetTexCoord, vec2(axis.y, -axis.x)) / radius;

    vec4 coord;
    vec4 myNormal = vec4(0.0, 0.0, 1.0, 1.0);

    if (angle <= 0.0) {                        // Flat section before curl
        coord = vec4(texCoord, 0.0, 1.0);
    } else {
        vec2 proj = dot(offsetTexCoord , axis) * (axis);
        const float PI = 3.14159265358979323846264;

        if (angle >= PI) {                    // Flat section after curl
            float axisAngle = asin(axis.x);
            proj += axis_origin;
            mat4 tr = translationThenRotationZ(proj.x, proj.y, 0.0, axisAngle);
            coord = vec4((PI - angle) * radius, 0.0, (radius + radius), 1.0);
            coord = tr * coord;

            myNormal.z = -1.0;
        } else {                            // Curl
            mat4 r = rotationxy(angle, axis);

            myNormal = r * myNormal;

            coord = vec4(proj, -axisOrigin.z, 1.0);
            r[3][0] = axisOrigin.x;
            r[3][1] = axisOrigin.y;
            r[3][2] = axisOrigin.z;
            coord = r * coord;
        }
    }
    gl_Position = transform_matrix * coord;

    shadeVarying = 0.25 + abs(myNormal.z) * 0.75;
    texCoordVarying = texCoord / tex_size;
}

mat4 rotationxy(float angle, vec2 axis)
{
    float x = axis.x;
    float y = axis.y;

    float xSqd = x * x;
    float ySqd = y * y;

    float xy = x * y;

    float cosAngle = cos(angle);
    float sinAngle = sin(angle);

    float xsinAngle = x * sinAngle;
    float ysinAngle = y * sinAngle;

    float oneMinusCos = 1.0 - cosAngle;

    float xyOneMinusCos = xy * oneMinusCos;

    mat4 target;
    target[0][0] = xSqd + (1.0 - xSqd)*cosAngle;
    target[0][1] = xyOneMinusCos;
    target[0][2] = ysinAngle;
    target[0][3] = 0.0;

    target[1][0] = xyOneMinusCos;
    target[1][1] = ySqd + (1.0 - ySqd)*cosAngle;
    target[1][2] = - xsinAngle;
    target[1][3] = 0.0;

    target[2][0] = - ysinAngle;
    target[2][1] = xsinAngle;
    target[2][2] = cosAngle;
    target[2][3] = 0.0;

    target[3][0] = 0.0;
    target[3][1] = 0.0;
    target[3][2] = 0.0;
    target[3][3] = 1.0;

    return target;
}

mat4 translationThenRotationZ(float x, float y, float z, float angle)
{
    float cosAngle = cos(angle);
    float sinAngle = sin(angle);

    mat4 target;
    target[0][0] = cosAngle;
    target[0][1] = -sinAngle;
    target[0][2] = 0.0;
    target[0][3] = 0.0;

    target[1][0] = sinAngle;
    target[1][1] = cosAngle;
    target[1][2] = 0.0;
    target[1][3] = 0.0;

    target[2][0] = 0.0;
    target[2][1] = 0.0;
    target[2][2] = 1.0;
    target[2][3] = 0.0;

    target[3][0] = x;
    target[3][1] = y;
    target[3][2] = z;
    target[3][3] = 1.0;

    return target;
}