public void guest_login_from_pick_screen(){

    GameId gameid =GameId.getInstance();
    WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 10);
    //gameid.currentGameId();//It will give the current CaseID from the GameID class
    wait.until(ExpectedConditions.urlMatches("https://web-game-stage.sportdec.com/games/"+gameid.getCurrentGameId()+"/join/"));
}