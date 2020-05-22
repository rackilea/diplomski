// Vector from the current pixel to the light
vec3 toLight = (lightpos - pixelpos);

// This computes how much is the pixel lit based on where it faces
float brightness = clamp(dot(normalize(toLight), pixelnormal), 0.0, 1.0);

// If it faces towards the light it is lit fully, if it is perpendicular
// to the direction towards the light then it is not lit at all.

// This reduces the brightness based on the distance form the light and the light's radius
brightness *= clamp(1.0 - (length(toLight) / lightradius), 0.0, 1.0);
// The final color of the pixel.
vec3 finalcolor = pixelcolor * lightcolor * brightness;
// If you have multiple lights multiply the pixel's color by the combined color of all lights
// like:
finalcolor = pixelcolor * (lightcolor1 * brightness1 + lightcolor2 * brightness2);

// Note that some things are clamped to avoid going into negative values