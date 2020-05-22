public class TbCd implements java.io.Serializable {
    @Override
    public String toString() {
        return "idCd=" + idCd + ", title=" + title + ", track= " + tbTracks;
    }
}

public class TbTrack implements java.io.Serializable {
    @Override
    public String toString() {
        return "idTrack=" + idTrack + ", title=" + title;
    }
}