public boolean insertData( String bgn, String nzd, String ils, String run, String cad,
                           String usd, String php, String chf, String zar, String aud, String jpy,
                           String TRY, String hkd, String myr, String thb, String hrk, String nok,
                           String idr, String dkk, String czk, String huf, String gbp, String mxn,
                           String krw, String isk, String sgd, String brl, String pln, String inr,
                           String ron, String cny, String sek){

    SQLiteDatabase database = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("BGN",bgn);
    contentValues.put("NZD",nzd);
    contentValues.put("ILS",ils);
    contentValues.put("RUB",run);
    contentValues.put("CAD",cad);
    contentValues.put("USD",usd);
    contentValues.put("PHP",php);
    contentValues.put("CHF",chf);
    contentValues.put("ZAR",zar);
    contentValues.put("AUD",aud);
    contentValues.put("JPY",jpy);
    contentValues.put("TRY",TRY);
    contentValues.put("HKD",hkd);
    contentValues.put("MYR",myr);
    contentValues.put("BGN",bgn);
    contentValues.put("THB",thb);
    contentValues.put("HRK",hrk);
    contentValues.put("NOK",nok);
    contentValues.put("IDR",idr);
    contentValues.put("DKK",dkk);
    contentValues.put("CZK",czk);
    contentValues.put("HUF",huf);
    contentValues.put("GBP",gbp);
    contentValues.put("MXN",mxn);
    contentValues.put("KRW",krw);
    contentValues.put("ISK",isk);
    contentValues.put("SGD",sgd);
    contentValues.put("BRL",brl);
    contentValues.put("PLN",pln);
    contentValues.put("INR",inr);
    contentValues.put("RON",ron);
    contentValues.put("CNY",cny);
    contentValues.put("SEK",sek);
    return database.insert(CURRENCY_TABLE, null, contentValues) != -1;
}