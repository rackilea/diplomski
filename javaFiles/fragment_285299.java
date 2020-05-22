String pdfFile="D:/PDFChartStuff.pdf";
if (pdfFile.toString().endsWith(".pdf")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfFile);
            } else {
               //For cross platform use
                Desktop desktop = Desktop.getDesktop();
                desktop.open(pdfFile);
            }