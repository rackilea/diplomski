bytesRead = in.read(inputBuffer);
while( bytesRead > 0 ){
    outputBuffer = cipher.update(inputBuffer, 0, readBytes); // only use the part read 
    out.write(outputBuffer);
    bytesRead = in.read(inputBuffer);
}
outputBuffer = cipher.doFinal(); // no data at all here, .update already processed it
out.write(outputBuffer);