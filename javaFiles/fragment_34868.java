// Only needed if normal vector (nx, ny, nz) is not already normalized.
float s = 1.0f / (nx * nx + ny * ny + nz * nz);
float v3x = s * nx;
float v3y = s * ny;
float v3z = s * nz;

// Calculate v1.
s = 1.0f / (v3x * v3x + v3z * v3z);
float v1x = s * v3z;
float v1y = 0.0f;
float v1z = s * -v3x;

// Calculate v2 as cross product of v3 and v1.
// Since v1y is 0, it could be removed from the following calculations. Keeping it for consistency.
float v2x = v3y * v1z - v3z * v1y;
float v2y = v3z * v1x - v3x * v1z;
float v2z = v3x * v1y - v3y * v1x;

// For each circle point.
px = cx + r * (v1x * cos(a) + v2x * sin(a))
py = cy + r * (v1y * cos(a) + v2y * sin(a))
pz = cz + r * (v1z * cos(a) + v2z * sin(a))