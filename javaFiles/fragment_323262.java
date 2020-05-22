for (i = 0; i < endMarker - 1; i++)
{
    String param1_celldata = edc.getExcelData(0, i + 1, columnParam);
    String param2_celldata = edc.getExcelData(0, i + 1, columnParam + 1);

    // iterate over the username passwords of the data.xls sheet to login and out as different users
    if (!param1_celldata.contains("Empty cell") && !param2_celldata.contains("Empty cell"))
    {
        LoginPage.login(driver, param1_celldata, param2_celldata);
        lo.logout_user_out(driver);
    }
}