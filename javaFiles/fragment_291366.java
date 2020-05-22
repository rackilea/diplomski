public class PizzaBot {

    private static final Logger LOG = Logger.getLogger(PizzaBot.class.getName());

    public static void main(String... args) throws Exception {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new TelegramLongPollingBot() {

            @Override
            public void onUpdateReceived(Update update) {
                Message message = update.getMessage();
                Long chatId = message.getChatId();
                String input = message.getText();
                if ("/recommendPizza".equals(input)) {
                    SendMessage request = new SendMessage();
                    request.setChatId(chatId.toString());
                    request.setText("Have a calzone!");
                    try {
                        sendMessage(request);
                    } catch (TelegramApiException e) {
                        LOG.log(Level.SEVERE, "Could not send message", e);
                    }
                }
            }

            @Override
            public String getBotUsername() {
                return "YOUR_BOT_USERNAME";
            }

            @Override
            public String getBotToken() {
                return "YOUR_BOT_TOKEN";
            }
        });
    }
}