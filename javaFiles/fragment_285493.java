for (int i = 0; i < a.radtot; i++) {
    file.write("" + i * a.rstep);

    for (int n = 0; n < a.timetot; n++) {
        file.write("\t " + T[n][i]);
        System.out.println(T[n][i] + " " + n + " " + i);
    }

    file.write("\n");
}
file.close(); // <-- Add this