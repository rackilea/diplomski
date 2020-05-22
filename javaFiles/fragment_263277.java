public class Pengiriman implements Comparable<Pengiriman> {

    private int no_resi = 0;
    private String nama_pengirim = "";
    private String alamat_tujuan = "";
    private String kota_tujuan = "";
    private String kecamatan_tujuan = "";
    private String kode_pos_tujuan = "";

    public Pengiriman() {  }

    public Pengiriman(int no_resi, String nama_pengirim, String alamat_tujuan,
            String kota_tujuan, String kecamatan_tujuan, String kode_pos_tujuan) {
        this.no_resi = no_resi;
        this.nama_pengirim = nama_pengirim;
        this.alamat_tujuan = alamat_tujuan;
        this.kota_tujuan = kota_tujuan;
        this.kecamatan_tujuan = kecamatan_tujuan;
        this.kode_pos_tujuan = kode_pos_tujuan;
    }

    public int getNoResi() {
        return no_resi;
    }

    public void setNoResi(int no_resi) {
        this.no_resi = no_resi;
    }

    public String getNamaPengirim() {
        return nama_pengirim;
    }

    public void setNamaPengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getAlamatTujuan() {
        return alamat_tujuan;
    }

    public void setAlamatTujuan(String alamat_tujuan) {
        this.alamat_tujuan = alamat_tujuan;
    }

    public String getKotaTujuan() {
        return kota_tujuan;
    }

    public void setKotaTujuan(String kota_tujuan) {
        this.kota_tujuan = kota_tujuan;
    }

    public String getKecamatanTujuan() {
        return kecamatan_tujuan;
    }

    public void setKecamatanTujuan(String kecamatan_tujuan) {
        this.kecamatan_tujuan = kecamatan_tujuan;
    }

    public String getKodePosTujuan() {
        return kode_pos_tujuan;
    }

    public void setKodePosTujuan(String kode_pos_tujuan) {
        this.kode_pos_tujuan = kode_pos_tujuan;
    }

    @Override
    public int compareTo(Pengiriman comparePengiriman) {
        int compareNoResi = comparePengiriman.getNoResi();

        //ascending order
        return this.no_resi - compareNoResi;

        // If you want Descending order then use this instead:
        // return compareNoResi - this.no_resi;
    }

    @Override
    public String toString() {
        return no_resi + ", " + nama_pengirim + ", " + alamat_tujuan
                + ", " + kota_tujuan + ", " + kecamatan_tujuan + ", "
                + kode_pos_tujuan;
    }
}