public boolean ayniVeriKontrol(String tc, String musteri_no) throws Exception{

    boolean kontrol = true;
    String geciciTc ,geciciNo;

    fileInputStream = new FileInputStream("Test.xls");
    isimsiz_banka_verileri = new HSSFWorkbook(fileInputStream);
    musteri = isimsiz_banka_verileri.getSheetAt(0);
    sayac = 1 + musteri.getLastRowNum();

    for (int i = 1; i < sayac; i++) {
        row2 = musteri.getRow(i);

        celli = row2.getCell(0);
        geciciTc = celli.getStringCellValue();

        celli = row2.getCell(3);
        geciciNo = celli.getStringCellValue();
        if (geciciTc.equals(tc)) {
            System.out.println("Ayılar");
            kontrol = false;
        }
    }

    fileInputStream.close();
    return kontrol;
}