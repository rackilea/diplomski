void makeRequestOnJava() 
{
    TextMesh txtm = GetComponent<TextMesh> ();
    var plugin = new AndroidJavaClass("com.example.plug2unity1.Plug1Class");
    txtm.text = plugin.CallStatic<string>("GetPlug1Text");
}

//Will be called from C# when the request is done
void OnRequestFinished()
{

}