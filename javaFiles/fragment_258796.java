try {
        Constants.res = Resources.open("/Lang.res");
    } catch (Exception e){
        System.err.println("can't load resource file:" + e);
    }
Hashtable h = Constants.res.getL10N("English.res","en");