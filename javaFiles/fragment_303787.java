highp int roundX = int(round(vertexPosition.x / squareSize));
highp float remainderX = vertexPosition.x - float(roundX)*squareSize;

vec2 dy = dFdy(vertexPosition.xy);
float minWidth = length(dy);

float w = smoothstep(min(lineWidth, minWidth), max(lineWidth, minWidth), abs(remainderX));
fragColor = mix(vec4(1.0, 0.0, 0.0, 1.0), vec4(0.8, 0.8, 0.8, 1.0), w);