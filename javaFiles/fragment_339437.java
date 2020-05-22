if (cevap == 1){
    pozitif++;
} else if (cevap == 0) {
    negatif++;
} else {
    Integer.parseInt(JOptionPane.showInputDialog(i + 1 + ". soru " + Soru[i] + "Lütfen (1) ve (0) giriniz!!!"));
}