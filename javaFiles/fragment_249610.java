JavaVMInitArgs args;
JavaVMOption options[3];
args.nOptions = 3;

options[0] = (char*)"-Xms256m";
options[1] = (char*)"-Xmx512m";
options[2] = //Your JAR file path.
args.options = options;