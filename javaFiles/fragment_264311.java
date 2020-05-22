public void CreateObject()
{
    runOnUiThread(new Runnable() 
    {   
        public void run()
        {
            HashMap<AdConfigKey, String> config = new HashMap<AdConfigKey, String>();
            config.put("my string1", "string1");
            config.put("my string2", "string2");
            config.put("my string3", "string3");

            MyObject = new MyObject(this, config);
            MyObject.setListener(this);
            MyObject.setLanguage(lang);
        }
    }
}