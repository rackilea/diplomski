class User<T extends Packet<?>> {
    PacketParser<T> mParser;

    User(PacketParser<T> parser){
        mParser = parser;
    }

    void DoSomething(){
         T packet = parser.obtainPacket();
         // do some stuff with the packet
         mParser.parse(packet);
    }
}

// and then when instantiating your User, specify the packet type:
new User<TypeOfPacket>(new ImplementedPacketParser())