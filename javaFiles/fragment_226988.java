# prepare class file output dir
mkdir -p bin

# collect all source files into list or prepare it manually
find src -iname *.java > file_list

# combine classpath by reference jars for example under lib dir
for p in $(ls lib); do cp="$cp:lib/$p"; done
# for p in $(ls lib); do cp="$cp;lib/$p"; done # for windows using ';' path separator

# compile 
javac -d bin -cp "$cp" @file_list