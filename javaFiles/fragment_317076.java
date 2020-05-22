InputStream is; // = something...

int read;
int read_total;

byte[] buf = new byte[128];

// Infinite loop    
while(true){
    read_total = 0;

    // Repeatedly perform reads until break or end of stream, offsetting at last read position in array
    while((read = is.read(buf, read_total, buf.length - offset)) != -1){
        // Gets the amount read and adds it to a read_total variable.
        read_total = read_total + read;

        // Break if it read_total is buffer length (128)
        if(read_total == buf.length){
            break;
        }
    }

    if(read_total != buf.length){
        // Incomplete read before 128 bytes
    }else{
        process_data(buf);
    }
}