SoapObject returnObj = (SoapObject)resultsRequestSOAP.getProperty("return");

    SoapObject finalReturn;
    for(int i=0;i<returnObj.getPropertyCount();i++){

        finalReturn= (SoapObject) returnObj.getProperty(i);

        Log.v("key", finalReturn.getProperty(0).toString()+" "+finalReturn.getProperty(1).toString());

    }