public static void main(String[] args) {
    customer akun = new customer();
    Scanner input = new Scanner(System.in);
    System.out.println("Nama akun : ");
    String  nama = input.nextLine();
    akun.setNama(nama);
    System.out.println("nama akun anda : "+akun.getNama());
}