public class JumpSearch {

    public static int jumpsearch(Pengiriman[] arrayPengiriman, int no_resi) {
        int n = arrayPengiriman.length;

        // Find the block size to skip
        int step = (int) Math.floor(Math.sqrt(n));

        // Finds the block where the element is located
        // present (if element present)
        int prev = 0;
        while (arrayPengiriman[Math.min(step, n) - 1].getNoResi() < no_resi) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        // Perform a linear search for x in blocks
        // starts with prev
        while (arrayPengiriman[prev].getNoResi() < no_resi) {
            prev++;

            // If you reach the next or last block
            // array, missing element.
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        // If an element is found
        if (arrayPengiriman[prev].getNoResi() == no_resi) {
            return prev;
        }
        return -1;
    }

    // Program for functional testing
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("|==============================================================================|");
        System.out.println("|    PROGRAM PENCARIAN DATA PENGIRIMAN BARANG DENGAN ALGORITMA JUMP SEARCH     |");
        System.out.println("|==============================================================================|");
        System.out.println("|    Case Finding Shipping Data With Recession Using Jump Search Algorithm     |");
        System.out.println("");

        // Array untuk menampung nilai tiap Data
        Pengiriman[] arrayPengiriman = new Pengiriman[16];

        arrayPengiriman[0] = new Pengiriman(101101, "Adam Kamil", "Jl.Anggrek", "Bogor", "Gunungbatu", "16118");
        arrayPengiriman[1] = new Pengiriman(101102, "Putra Mandala", "Jl.Apel", "Kerawang", "Kerawang Barat", "41311");
        arrayPengiriman[2] = new Pengiriman(101103, "Mamat Sanusi", "Jl.Merpati", "Jakarta Selatan", "Lenteng Agung", "12610");
        arrayPengiriman[3] = new Pengiriman(101104, "Kamila Akhwan", "Jl.Kelapa", "Bekasi", "Bekasi Timur", "17111");
        arrayPengiriman[4] = new Pengiriman(101105, "Putra Iskandar", "Jl.Anggrek 2", "Bogor", "Menteng", "16111");
        arrayPengiriman[5] = new Pengiriman(101106, "Nabila Putri", "Jl.Merapi", "Palu", "Tatanga", "94239");
        arrayPengiriman[6] = new Pengiriman(101107, "Imam Satya", "Jl.Pulau Nias", "Manado", "Bunaken", "95231");
        arrayPengiriman[7] = new Pengiriman(101108, "Robby Dermawan", "Jl.Tajung Pura", "Yogyakarta", "Gondokusuman", "55225");
        arrayPengiriman[8] = new Pengiriman(101109, "Adrian Suta", "Jl.Dewi Sartika", "Banggai", "Luwuk", "94712");
        arrayPengiriman[9] = new Pengiriman(1011010, "Rizky Prima", "Jl.Gunung Jati", "Jayawijaya", "Wamena", "99511");
        arrayPengiriman[10] = new Pengiriman(1011011, "Margareth Warouw", "Jl.Sawit", "Jakarta Timur", "Cibubur", "13720");
        arrayPengiriman[11] = new Pengiriman(1011012, "Jeni Indira", "Jl.Tuna", "Bekasi", "Bekasi Barat", "17136");
        arrayPengiriman[12] = new Pengiriman(1011013, "Asep Suratman", "Jl.Palapa", "Bogor", "Margajaya", "16116");
        arrayPengiriman[13] = new Pengiriman(1011014, "Gigi Purnama", "Jl.Keraton Atas", "Bekasi", "Setu", "17320");
        arrayPengiriman[14] = new Pengiriman(1011015, "Kamila Dewi", "Jl.Dago Timur", "Bandung", "Coblong", "40135");
        arrayPengiriman[15] = new Pengiriman(1011016, "Desy Sambeta", "Jl.Proklamasi", "Surabaya", "Wonocolo", "60239");

        // Sort the Object Array        
        Arrays.sort(arrayPengiriman);

        System.out.println("|==============================================================================|");
        System.out.println("|                                DATA PENGIRIMAN                               |");
        System.out.println("|==============================================================================|");
        System.out.println("");

        // Displays the Ascending Sorted Array   
        for (int i = 0; i < 16; i++) {
            System.out.println("  " + (i + 1) + ". " + arrayPengiriman[i].toString());
        }

        // Apply the Search Mechanism...
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|==============================================================================|");
        System.out.println("|                               SEARCH SHIPPING DATA                           |");
        System.out.println("|==============================================================================|");
        System.out.println("");

        // Enter 'noRes'
        System.out.print("    Enter the receipt number you want to search for: ");
        int no_resi = scan.nextInt();

        // Finding index of 'x' with jump search
        int index = jumpsearch(arrayPengiriman, no_resi);

        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("|==============================================================================|");
        System.out.println("|                       RESULTS OF SHIPPING DATA RESULTS                        |");
        System.out.println("|==============================================================================|");
        System.out.println("");

        // Displays the index where 'x' is found
        if (no_resi != -1 && index != -1) {
            System.out.println("Shipping data with " + no_resi
                    + " found in index to " + index);
        }
        else {
            System.out.println("Shipping data with Receipt No " + no_resi
                    + " not found");
        }
        System.out.println("|==============================================================================|");
    }
}