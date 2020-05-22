String str = "Compile";
for (int z = 0; z < str.length(); z++) {
    char ans = str.charAt(z);
    for (int x = 0; x < z; x++) {
        System.out.print(" ");
    }
    System.out.println(ans);
}