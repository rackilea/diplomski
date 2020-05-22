$ file FailingFile.java
FailingFile.java: ASCII text, with CRLF line terminators

$ cat -v FailingFile.java
package foo.bar.baz;^M        <--- note hidden control char revealed by -v

$ get_package_name FailingFile.java
class_base_name:FailingFile
package_name get result:0
package_name:foo.bar.baz
.FailingFilesspath_name:foo.bar.baz