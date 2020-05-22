srv = net.createServer(net.TCP)

function receiver(sck, data)
  print(data)
  print()

  -- if you're sending back HTML over HTTP you'll want something like this instead
  local response = {"HTTP/1.0 200 OK\r\nServer: NodeMCU on ESP8266\r\nContent-Type: text/html\r\n\r\n"}

  response[#response + 1] = "<!doctype html><html>"
  response[#response + 1] = "<h1> ESP8266 Web Server</h1>"
  response[#response + 1] = "</html>"

  -- sends and removes the first element from the 'response' table
  local function send(localSocket)
    if #response > 0 then
      localSocket:send(table.remove(response, 1))
    else
      localSocket:close()
      response = nil
    end
  end

  -- triggers the send() function again once the first chunk of data was sent
  sck:on("sent", send)

  send(sck)
end

srv:listen(80, function(conn)
  conn:on("receive", receiver)
end)