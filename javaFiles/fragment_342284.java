int vertShade = glCreateShader(GL_VERTEX_SHADER);
glShaderSource(vertShade,Reader.read("shaders/main.frag"));
glCompileShader(vertShade);
int fragShade = glCreateShader(GL_FRAGMENT_SHADER);
glShaderSource(fragShade,Reader.read("shaders/main.frag"));
glCompileShader(fragShade);