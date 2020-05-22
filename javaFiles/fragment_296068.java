String isDisabled = textlink.getAttribute("disabled");
if (isDisabled==null || !isDisabled.equals("disabled")){
   System.out.println("View link: Enabled");
}else{
   System.out.println("View link: Disabled");
}