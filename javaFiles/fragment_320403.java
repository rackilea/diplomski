$ file WorkingFile.java
WorkingFile.java: ASCII text

$ cat -v WorkingFile.java
package foo.bar.baz;

$ get_package_name WorkingFile.java
class_base_name:WorkingFile
package_name get result:0
package_name:foo.bar.baz
method 1 classpath_name:foo.bar.baz.WorkingFile