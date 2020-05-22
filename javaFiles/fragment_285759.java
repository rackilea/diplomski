require 'java'
java_import 'YourJavaClass'

a = YourJavaClass.new
hash = {}
a.java_class.fields.each{ |var| hash[var.name] = var.value(a) }
p hash