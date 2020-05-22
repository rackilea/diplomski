public void kullaniciGuncelle(String tc, String ad, String soyad, String musteri_no, String telefon, String hesap_turu)throws Exception{


    if (ayniVeriKontrol(tc,musteri_no)){
        fileInputStream = new FileInputStream("Test.xls");
        isimsiz_banka_verileri = new HSSFWorkbook(fileInputStream);

        musteri =isimsiz_banka_verileri.getSheetAt(0);
        sayac = 1 + musteri.getLastRowNum();
        row2 = musteri.createRow(sayac);
        celli = row2.createCell(0);
        celli.setCellValue(tc);
        celli = row2.createCell(1);
        celli.setCellValue(ad);
        celli = row2.createCell(2);
        celli.setCellValue(soyad);
        celli = row2.createCell(3);
        celli.setCellValue(musteri_no);
        celli = row2.createCell(4);
        celli.setCellValue(telefon);
        celli = row2.createCell(5);
        celli.setCellValue(hesap_turu);

        fileInputStream.close();

        fileOutputStream = new FileOutputStream("Test.xls");
        isimsiz_banka_verileri.write(fileOutputStream);
        isimsiz_banka_verileri.close();
        fileOutputStream.close();
    }
    else{
        KayitArayuzu kayit = new KayitArayuzu();
    }


}