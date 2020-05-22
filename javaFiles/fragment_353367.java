if(cell == null) {
              Cell cell = row.createCell(j);

              if (j = 0) cell.setCellValue(title);
              if (j = 1) cell.setCellValue(url);
              if (j = 2) {
                   cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy h:mm:ss"));
                   cell.setCellValue(new Date());
                   cell.setCellStyle(cellStyle);
              }
              if (j == 3) {  
                  if (driver.getCurrentUrl().contains("https://www.google.com")) {
                     cell.setCellValue("OK");
                     System.out.println("Page title contains- Google. Status is OK. ");
                  } else {
                      cell.setCellValue("NOT OK");
                      System.out.println("Page title doesn't contain - Google. Status is NOT OK. ");
                  }
              }
          }