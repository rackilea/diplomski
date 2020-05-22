require 'socket'
server = TCPServer.new(12345).accept
line = server.recv(50)
puts "Message from java Client: #{line}"
server.flush
server.puts("Hi from server!")
server.flush