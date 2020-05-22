for (Message m : chatList) {
                LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View message = li.inflate(R.layout.msgbubble, null);

                TextView messageText = message.getRootView().findViewById(R.id.messageText);
                messageText.setText(m.messageText);
                LinearLayout msgBubble = message.findViewById(R.id.bubbleLayout);


                if (userID == m.sender.id) {
                    msgBubble.setGravity(Gravity.RIGHT);
                    messageText.setBackgroundColor(getResources().getColor(R.color.inBlue));
                }
                if (userID == m.recipient.id) {
                    msgBubble.setGravity(Gravity.LEFT);
                    messageText.setBackgroundColor(getResources().getColor(R.color.outBlue));
                }
                messageContainer.addView(message);
            }