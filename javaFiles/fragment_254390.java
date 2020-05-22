String webContext = driver.getContext();
    Set<String> contexts = driver.getContextHandles();
    for (String context: contexts){
        if (context.contains("NATIVE_APP")){
            driver.context(context);
            break;
        }
    }
    driver.findElement(By.id("android:id/button1")).click();