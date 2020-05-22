import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.webscrap4j.WebScrap;
import com.webscrap4j.WebScrapException;


public class okayapower_battery {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {

        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> bl = new ArrayList<String>();
        ArrayList<String> cl = new ArrayList<String>();
        WebScrap ws = new WebScrap();
        for(int page=1; page<=10; page++) {
            ws.setUrl("https://www.okayapower.com/product-category/inverter/page/" + String.valueOf(page) + "/");
            try {
                ws.startWebScrap();
                //al = ws.getImageTagData("img", "title");
                al = ws.getSingleHTMLScriptData("<h3>", "</h3>");
                bl = ws.getSingleHTMLScriptData("<del>", "</del>");
                cl = ws.getSingleHTMLScriptData("<ins>", "</ins>");

                HSSFWorkbook workBook = new HSSFWorkbook();
                FileOutputStream fos = new FileOutputStream("/Users/parthpatil/Documents/Abm Technologies/Crawl/okaya_battery.xls"); {

                    // Create the Sheet
                    HSSFSheet Sheet = workBook.createSheet("products");

                    // Create the first row corresponding to the header
                    Row header = Sheet.createRow(0);
                    header.createCell(0).setCellValue("Product Name");
                    header.createCell(1).setCellValue("Product Price");
                    header.createCell(2).setCellValue("Product MRP");

                    // Ensure that all the List have the same size otherwise throw an exception
                    if (al.size() != bl.size() || al.size() != cl.size())
                        throw new IllegalStateException("Some data is missing");

                    // Iterate over all the list an create the rows of data
                    for(int i = 0; i < al.size(); i++){
                        // Create the current starting from 1 to al.size()
                        HSSFRow row = Sheet.createRow((short) i + 1);
                        // Cell of the Product Name
                        row.createCell(0).setCellValue(al.get(i));
                        // Cell of the Product Price
                        row.createCell(1).setCellValue(cl.get(i));
                        // Cell of the Product MRP
                        row.createCell(2).setCellValue(bl.get(i));
                    }
                    // Write the result into the file
                    workBook.write(fos);

                    for (String adata : al)
                    {
                        System.out.println("the product are:- " + adata);
                    }
                    for (String bdata : bl)
                    {
                        System.out.println("the MRp are:- " + bdata);
                    }
                    for (String cdata : cl)
                    {
                        System.out.println("the selling price is:- " + cdata);
                    }
                }
            } catch (WebScrapException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}