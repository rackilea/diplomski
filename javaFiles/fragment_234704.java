WebElement buton=driver.findElement(By.className("android.widget.Button"))
if(button.isDisplayed()) {  
        System.out.println("İzle butonlarının görülme durumu="+buton);
}
else{
          Assert.assertTrue("İzle butonu ekranda görülmedi!!.",buton); }
    ......