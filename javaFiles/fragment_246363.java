JTextArea shortText = makeMultiLineLabel(true);
shortText.setBorder(BorderFactory.createEtchedBorder());
shortText.setFont(shortText.getFont().deriveFont(Font.BOLD));
//       FontMetrics fm = shortText.getFontMetrics(
//                shortText.getFont());
//        shortText.setPreferredSize(new Dimension(
//                Math.min(fm.stringWidth(shortMessage), 300),
//                fm.getHeight()));
shortText.setRows(2);
shortText.setColumns(20);
shortText.setText(shortMessage);

JTextArea messageText = makeMultiLineLabel(true);
messageText.setBorder(BorderFactory.createEtchedBorder());
messageText.setFont(shortText.getFont().deriveFont(Font.PLAIN));
//        fm = messageText.getFontMetrics(
//                messageText.getFont());
//        messageText.setPreferredSize(new Dimension(
//                Math.min(fm.stringWidth(message), 300),
//                fm.getHeight()));
messageText.setRows(4);
messageText.setColumns(20);
messageText.setText(message);