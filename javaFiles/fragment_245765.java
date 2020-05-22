# remove un-needed environment variable
unset LD_LIBRARY_PATH
# set proper shared library names on MacOSX in 
for n in libjejdb.dylib libjejdb.1.dylib libjejdb.1.0.0.dylib; do ln -s libjejdb.so ~/test/lib/$n; done
# Relaunch example using your previous command
java -Djava.library.path=/Users/foo/test/lib -jar jejdb-sample1.jar