public static boolean primo(int numero) {
    for (int i = 2; i <= numero/2; i++) {
        if (numero % i == 0){
            return false;
        }
    }
    return true;
}