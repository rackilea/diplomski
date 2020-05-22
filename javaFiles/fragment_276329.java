if (packet == null) {
    throw new NullPointerException("packet is null")
} else if (packet.findChild("x","http://jabber.org/protocol/muc#user") == null) {
    throw new NullPointerException("packet.findChild(\"x\",\"http://jabber.org/protocol/muc#user\") is null")
}
item = packet.findChild("x","http://jabber.org/protocol/muc#user").findChild("item");