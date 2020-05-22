// we're inside the nextPacket(PcapPacket currentPacket, String user) method
buffer.lock();
for(int j = 0; j<buffer.size(); j++){
    if(currentPacket.getCaptureHeader().caplen() == buffer.get(j).getCaptureHeader().caplen() 
        && packet.size() == buffer.get(j).size()){

        buffer.erasePacket(j);

        return;
    }

}
buffer.unlock();
// continue packet processing