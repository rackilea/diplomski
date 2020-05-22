String test = "ilaç etkileşimleri: Antihistaminikler alkol ve antidepresanların etkilerinde artmaya yol açabilirken fenilpropanolamin'in b-adrenerjik blokerlerle beraber kullanılması.\n\n"+
                "^^Endikasyonları: Grip ve soğuk algınlığına bağlı burun tıkanıklığı ve burun akıntısı, aksırma, burun ve boğazda kaşıntı, baş ağrısı, adale ağrısı, boğaz ağrısı, vücut kırıklığı, ateş, nezle, gözlerde sulanma ve kaşıntı gibi durumlarda kullanılır.\n\n"+
                "^^Uyarılar/Önlemler: A-ferin forte tablet, sedasyona yol açabilir. Bu nedenle dikkat gerektiren makinalarda çalışanlarda, tehlikeli ve/veya yüksek yerlerde çalışanlarda veya vasıta kullananlarda kazaya neden olabileceğinden A-ferin forte tablet kullanımı sırasında bu gibi işler yapılmamalıdır.";
String [] arr = test.split("\\^\\^");
for(String s : arr) {
    System.out.println(s);
}