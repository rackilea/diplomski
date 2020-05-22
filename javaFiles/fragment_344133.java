SendMessage sendMessage = new SendMessage()
            .setChatId(chat_id)
            .setText("You send /start");

    // create keyboard
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    sendMessage.setReplyMarkup(replyKeyboardMarkup);
    replyKeyboardMarkup.setSelective(true);
    replyKeyboardMarkup.setResizeKeyboard(true);
    replyKeyboardMarkup.setOneTimeKeyboard(true);

    // new list
    List<KeyboardRow> keyboard = new ArrayList<>();

    // first keyboard line
    KeyboardRow keyboardFirstRow = new KeyboardRow();
    KeyboardButton keyboardButton = new KeyboardButton();
    keyboardButton.setText("Share your number >").setRequestContact(true);
    keyboardFirstRow.add(keyboardButton);

    // add array to list
    keyboard.add(keyboardFirstRow);

    // add list to our keyboard
    replyKeyboardMarkup.setKeyboard(keyboard);

    try {
        sendMessage(sendMessage);
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }


}else{
    System.out.println("#############");
    System.out.println(update.getMessage().getContact());
    System.out.println("#############");