String call_data = update0.getCallbackQuery().getData();
            long message_id = update0.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update0.getCallbackQuery().getMessage().getChatId();
            String inline_message_id = update0.getCallbackQuery().getInlineMessageId();
            if (call_data.equals("change_the_label")) {
                String answer = "Updated message text";
                EditMessageReplyMarkup new_message = new EditMessageReplyMarkup()
                        .setChatId(chat_id).setMessageId(toIntExact(message_id))
                        .setInlineMessageId(inline_message_id);
                InlineKeyboardButton dk1=new InlineKeyboardButton();
                dk1.setText("label1");
                dk1.setCallbackData("change_the_label");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();

                rowInline.add(dk1);

                rowsInline.add(rowInline);

                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);

                                try {editMessageReplyMarkup(new_message);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }