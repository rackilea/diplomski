HTMLWorker htmlWorker = new HTMLWorker(document);
            if(bodyStr!=null)
            {

                //find inline images
                inlineImages=downloadInLineImage(mostRecentMatch, dynamicOutputDirectory);
                if(inlineImages!=null)
                {

                    for (Map.Entry<String, String> entry : inlineImages.entrySet()) {
                        //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        bodyStr=bodyStr.replaceAll("cid:"+entry.getKey() , entry.getValue());
                    }
                }
                htmlWorker.parse(new StringReader(bodyStr));

        }