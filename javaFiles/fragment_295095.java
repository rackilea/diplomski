public static void main(String[] args) {
    String[] unchangedFileInput = { "AVACADO", "CHICKEN", "BACON",
            "AARDVARK", "NAAN" };
    String[] changedFileInput = new String[unchangedFileInput.length];
    for (int i = 0; i < unchangedFileInput.length; i++) {
        changedFileInput[i] = transformName(unchangedFileInput[i]);
        System.out.printf("%s = %s%n", unchangedFileInput[i],
                changedFileInput[i]);
    }
}