String data = 
          " INSERT INTO PUBLIC.EMPLOYEE(ID, NAME) VALUES\r\n"
        + "    (1, 'Madhava'),\r\n" + "    (2, 'Rao'),\r\n"
        + "    (3, 'Tmr');  \r\n" + "\r\n"
        + "    INSERT INTO PUBLIC.ADDRESS(ID, CITY) VALUES\r\n"
        + "    (1, 'Bangalore'),\r\n" + "    (2, 'Chirala'),\r\n"
        + "    (3, 'Pune'); ";
List<String> inserts = new ArrayList<>();
Scanner sc = new Scanner(data); //you can also use new Scanner(new File("location/of/your/textfile.sql"));