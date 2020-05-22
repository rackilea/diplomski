try {
    main.saveGame(player); // throw exception
} catch (IOException e) {
    //some error processing
    e.printStackTrace();
}