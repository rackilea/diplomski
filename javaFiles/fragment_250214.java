public class Download {
    String company_id = "";
    String company_Name = "";
    String pdfInfo = "";
    String pdfLinkDownload = "";
    String s= "";

    public void downloadHTMLWithPDFolder(String company_id,
        String pdfLinkDownload,
        String pdfInfo,
        String company_Name)
        throws MalformedURLException, IOException {
            int company = 0;
        this.company_id = company_id;
        this.company_Name = company_Name;
        this.pdfInfo = pdfInfo;
        this.pdfLinkDownload = pdfLinkDownload;
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        File file=new File("E:\\ALL");

        company = Integer.parseInt(company_id);
        company ++;
        s =  ""+company;

        if(!file.exists()) {
            file.mkdirs();
        }

        File fileid=new File("E:\\ALL\\"+company_id);
        if(!fileid.exists()) {
            fileid.mkdirs();
        }
        File file1=new File("E:\\ALL\\"+company_id+"\\"+company_Name);
        if(!file1.exists()) {
            file1.mkdirs();
        }
        File filec=new File("E:\\ALL\\"+company_id+"\\"+company_Name+"\\"+s);
        if(!filec.exists()) {
            filec.mkdirs();
        }
        try {
            System.out.println("open...");
            pdfInfo.replaceAll("/","");
            fout  =new FileOutputStream("E:\\ALL\\"+company_id+"\\"+company_Name+"\\"+s+"\\"+company_Name+company_id+company+".htm");
            System.out.println("LINK : " + pdfLinkDownload);
            in = new BufferedInputStream(new URL(pdfLinkDownload).openStream());


            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
            System.out.println("fileDwonloaded   ....***");
        }
    }
}