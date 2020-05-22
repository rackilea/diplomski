if (resultText.equalsIgnoreCase("open browser"))
{
    try{
        Runtime.getRuntime().exec("cmd /c start chrome.exe");
    }catch(Exception ae){}
}