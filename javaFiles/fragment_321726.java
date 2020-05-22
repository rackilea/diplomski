//since you know the job
String job = "A01763431 Job YYY";

String dataRowIndex = driver.findElement(By.cssSelector("[data-job='" + job + "']")).getAttribute("data-row-index");

System.out.println(dataRowIndex);