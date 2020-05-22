int rowCount = xlib.getRowCount("Sheet1");

for (int i = 0; i<=rowCount;i++)
{
    try {
        String compair1= xlib.getExcelData("Sheet1", i, 0);
        System.out.println(compair1);
        String compair2=xlib.getExcelData("Sheet2", i, 0); 
        System.out.println(compair2);
        Assert.assertEquals(compair1, compair2);
        System.out.println("compared successfully");
    } catch (Exception e) {
        continue;
    }
}