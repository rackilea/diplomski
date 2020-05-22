float orthoMat[] =
{
    2.0f / (right - left),
    0,
    0,
    0,

    0,
    2.0f / (top - bottom),
    0,
    0,

    0,
    0,
    2.0f / (zFar - zNear),
    0,

    -(right + left) / (right - left),
    -(top + bottom) / (top - bottom),
    -(zFar + zNear) / (zFar - zNear),
    1
};