String stored_report = selenium.getBodyText();

File f = new File("C:/folder/" + "report" + ".html");
FileWriter writer = new FileWriter(f,true);
writer.write(stored_report);
System.out.println("Report Created is in Location : " + f.getAbsolutePath())
writer.close();