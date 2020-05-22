class PuntoNota implements Parcelable {
    private String punto;
    private String nota;

    public PuntoNota(String punto, String nota) {
        this.punto = punto;
        this.nota = nota;
    }

    protected PuntoNota(Parcel in) {
        punto = in.readString();
        nota = in.readString();
    }

    public String getPunto() {
        return punto;
    }

    public String getNota() {
        return nota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(punto);
        dest.writeString(nota);
    }

    public static final Creator<PuntoNota> CREATOR = new Creator<PuntoNota>() {
        @Override
        public PuntoNota createFromParcel(Parcel in) {
            return new PuntoNota(in);
        }

        @Override
        public PuntoNota[] newArray(int size) {
            return new PuntoNota[size];
        }
    };
}