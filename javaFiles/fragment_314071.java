URL url = new URL("http://cdn.sstatic.net/stackoverflow/all.css?v=e97b23688ee8"); // some css on this site
HttpURLConnection con = (HttpURLConnection) url.openConnection();

Scanner scanner = new Scanner(con.getInputStream());
while(scanner.hasNextLine()) 
    System.out.println(scanner.nextLine());

System.out.println(con.getContentType()); // prints text/css