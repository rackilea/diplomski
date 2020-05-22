if (event.isRXCHAR() && event.getEventValue() > 0) {
    try {
        char receivedData = serialPort.read(event.getEventValue());
        if (recvData) === '#' {
            this.readString = 1
        }else if(recvData === '$'){
            this.readString = 0
        }

        if(this.readString == 1){
            this.recvStringData.append(receivedData)
            System.out.println(this.recvStringData);
        }

        if(this.recvStringData == "Arduino Ready") JTAC.ready = true;

    } catch (SerialPortException ex) {
        System.out.println("Error in receiving string from COM-port: " + ex);
    }
}