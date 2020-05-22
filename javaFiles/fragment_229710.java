// Object state
speed = ...; // Unit is [m/s]
position = ...; // Unit is [m]   


// Inputs
frameDelta = ...; // Unit is [s]
acceleration = ...; // Unit is [m/s^2]

// Update step
speed += acceleration * frameDelta; // Unit [m/s^2 * s] = [m/s];
position += speed * frameDelta; // Unit [m/s * s] = [m]