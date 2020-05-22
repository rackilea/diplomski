int i=1;
for(WebElement element: allElements){
if(i==6)
break; //break the loop
system.out.println(""+element.getText());
i++;
}