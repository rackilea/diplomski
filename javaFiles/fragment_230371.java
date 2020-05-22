/*Get the list of iframes*/
List<SelenideElement> myIframes = $$("iframe");

/* For loop that makes sure that the list of iframes is bigger than 0 */
for (int i=1; myIframes.size() < 1; i++){
    Thread.sleep(100);
    myIframes = $$("iframe");
    /* if the script waits for 10 seconds, break out of the for loop. */
    if(i > 99){
        System.out.println("Breaking out of for loop, list of iFrames contains : " + myIframes.size() + " frame.");
        break;
    }
}