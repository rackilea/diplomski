outPutFolder=getDir("example", Context.MODE_PRIVATE) + "/"+fileName +"/" ;
          //your directory name

  try {

        epubInputStream=new FileInputStream(filePath);

    } catch (IOException e1) {

        e1.printStackTrace();
    }


    try {
        book = (new EpubReader()).readEpub(epubInputStream);
    } catch (IOException e) {

        e.printStackTrace();
    }

    outPutFolder=getDir("example", Context.MODE_PRIVATE) + "/"+fileName +"/" ;
    setOutPutFolder(outPutFolder);

    DownloadResource(outPutFolder);



    linezNew = "";
    Spine spine = book.getSpine();
    List<SpineReference> spineList = spine.getSpineReferences() ;
    int count = spineList.size();

    StringBuilder string = new StringBuilder();
    for (int i = 0; count > i; i++) {

        Resource res = spine.getResource(i);

        try {
            InputStream is = res.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    linezNew =   string.append(line + "\n").toString();
                }

            } catch (IOException e) {e.printStackTrace();}


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    linezNew = linezNew.replace("../", "");

    finalDataToLoad="<head><style>img{max-width: 100%; width:50%; height: 50%;}</style></head> "+linezNew;


  webView.loadDataWithBaseURL("file://" + outPutFolder, finalDataToLoad, "text/html", "utf-8", null);