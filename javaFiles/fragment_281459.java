// writing

socket.getOutputStream.write(myDtoObject);

// reading
MyDTO dto = (MyDTO) socket.getInputStream.readObject();