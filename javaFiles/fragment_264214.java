open a socket connected to the sender
is = socket.getInputStream()
initialize buffer, offset, and length
while the socket is good
    bytesRead = is.read(buffer, offset, length)
    if(bytesRead <= 0)
        bail out you have an error
    offset += bytesRead;
    length -= bytesRead 
    if(you have a complete message)
        copy the message out of the buffer (or parse the message here into
          some other data structure)
        publishProgress(the message)
        reset buffer offset and length for the next message.
         (remember you may have received part of the following message)
    end-if
end-while