public class Test
{
    public static List<Account> readFile()
    {
        String file = "C:\\workspace\\practise\\test.txt";
        BufferedReader br = null;
        String line = "";
        String splitter = "\\|";
        List<Account> accountList = new ArrayList<Account>();
        try
        {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null)
            {
                Account a = null;
                String[] accounts = line.split(splitter);
                if (accounts.length > 1)
                {
                    a = new Account(accounts[0], accounts[1]);
                } else
                {
                    a=new Account(accounts[0], "");
                }
                accountList.add(a);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return accountList;
    }

    public static void main(String[] args)
    {
        List<Account> acct = readFile();
        for (Account account : acct)
        {
            System.out.println(account);
        }
    }
}