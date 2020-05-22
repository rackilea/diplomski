String pat = "\\[QUOTE=[^\\[]*(?:\\[(?!/QUOTE])[^\\[]*)*\\[/QUOTE]";
String str = "[QUOTE=SynapseBreak;104047835]Armchio de dragon is satki dragon lai de leh\n\n[URL=\"https://play.google.com/store/apps/details?id=com.shiportal.hwzreader&referrer=utm_source%3Dsignature%26utm_medium%3Dforum\"]Sent from &#27402;&#24535;-&#40845; using GAGT[/URL][/QUOTE]\nwhy satki ? tell me :s13:\n[QUOTE=articated;104047854]I not sad lah\nU happy i happy kym\n\nJust for fun loh :s12:\n[ms]&#33258;&#24478;&#25105;&#35722;&#25104;&#20102;&#29399;&#23630;&#65292;&#23601;&#20877;&#20063;&#27794;&#26377;&#20154;&#25954;&#36393;&#22312;&#25105;&#38957;&#19978;&#20102; HardwareZone Forums app[/ms][/QUOTE]\ntoday arti jin sweet make me happy :s12:\n\n[QUOTE=Iandao;104047967]Gg mbs now...[/QUOTE]\ngo there jiak simi ??'";
String res = str.replaceAll(pat, "");
System.out.println(res); 
// => why satki ? tell me :s13:
//
//    today arti jin sweet make me happy :s12:
//
//
//     go there jiak simi ??'