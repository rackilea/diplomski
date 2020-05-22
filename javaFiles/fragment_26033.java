import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class ParseCSVtoJavaBean 
{
    public static void main(String args[])
    {
        CSVReader csvReader = null;

        try
        {
            /**
             * Reading the CSV File
             * Delimiter is comma
             * Default Quote character is double quote
             * Start reading from line 1
             */
            csvReader = new CSVReader(new FileReader("Employee.csv"),',','"',1);
            //mapping of columns with their positions
            ColumnPositionMappingStrategy mappingStrategy = 
                    new ColumnPositionMappingStrategy();
            //Set mappingStrategy type to Employee Type
            mappingStrategy.setType(Employee.class);
            //Fields in Employee Bean
            String[] columns = new String[]{"empId","firstName","lastName","salary"};
            //Setting the colums for mappingStrategy
            mappingStrategy.setColumnMapping(columns);
            //create instance for CsvToBean class
            CsvToBean ctb = new CsvToBean();
            //parsing csvReader(Employee.csv) with mappingStrategy  
            List empList = ctb.parse(mappingStrategy,csvReader);
            //Print the Employee Details
            for(Employee emp : empList)
            {
                System.out.println(emp.getEmpId()+"   "+emp.getFirstName()+"   "
                        +emp.getLastName()+"   "+emp.getSalary());

            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                //closing the reader
                csvReader.close();
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }
}