a = A.new
a.field1 = 1
a.field2 = 2
methods = a.public_methods(false).select { |s| s.end_with?("=") }
attributes = Hash[methods.map { |m| [m, a.send(m)] }]
=> {"field1"=>1, "field2"=>2}