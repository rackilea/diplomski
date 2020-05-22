public class Connection {

    String srcAddr, dstAddr, protocol; int srcPort, dstPort;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dstAddr == null) ? 0 : dstAddr.hashCode());
        result = prime * result + dstPort;
        result = prime * result
                + ((protocol == null) ? 0 : protocol.hashCode());
        result = prime * result + ((srcAddr == null) ? 0 : srcAddr.hashCode());
        result = prime * result + srcPort;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Connection other = (Connection) obj;
        if (dstAddr == null) {
            if (other.dstAddr != null)
                return false;
        } else if (!dstAddr.equals(other.dstAddr))
            return false;
        if (dstPort != other.dstPort)
            return false;
        if (protocol == null) {
            if (other.protocol != null)
                return false;
        } else if (!protocol.equals(other.protocol))
            return false;
        if (srcAddr == null) {
            if (other.srcAddr != null)
                return false;
        } else if (!srcAddr.equals(other.srcAddr))
            return false;
        if (srcPort != other.srcPort)
            return false;
        return true;
    }

}