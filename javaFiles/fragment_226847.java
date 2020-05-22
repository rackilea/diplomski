shiny_source = <<-EOF
  package foo.bar.baz;
  public class Shiny {
    public Shiny() {
      System.out.println("I'm shiny!");
    }
  }
EOF

require 'java'
java_import javax.tools.SimpleJavaFileObject
java_import java.net.URI

class JavaSourceFromString < SimpleJavaFileObject
  def initialize(name, code)
    uri = "string:///" + name.gsub('.', '/') + Kind::SOURCE.extension
    super URI.create(uri), Kind::SOURCE
    @code = code
  end

  def getCharContent(ignore_encoding_errors)
    @code
  end
end

java_import javax.tools.ToolProvider
java_import java.io.StringWriter
java_import java.net.URL
java_import java.net.URLClassLoader

compilation_path = java.nio.file.Paths.get('tmp').to_absolute_path.to_s
jc = ToolProvider.get_system_java_compiler
raise "Compiler unavailable" unless jc

jsfs = JavaSourceFromString.new('foo.bar.baz.Shiny', shiny_source)
file_objects = [jsfs]
ccl = java.lang.Thread.current_thread.get_context_class_loader
classpath = ccl.getURLs.to_a.join(java.io.File::pathSeparator)
options = ['-d', compilation_path, '-classpath', classpath]
output = StringWriter.new
success = jc.get_task(output, nil, nil, options, nil, file_objects).call
raise output unless success

url = URL.new("file:" + compilation_path + "/")
ucl = URLClassLoader.new_instance([url].to_java(URL))
shiny_class = ucl.load_class('foo.bar.baz.Shiny')
shiny_class.new_instance