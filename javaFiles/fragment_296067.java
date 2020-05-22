TerminalFactory terminalFactory = TerminalFactory.getDefault();
CardTerminal terminal = terminalFactory.terminals().list().get(0);
Card card = terminal.connect("T=0");
CardChannel channel = card.getBasicChannel();

// Construct a command and transmit it
CommandAPDU command = new CommandAPDU(new byte[]{(byte)0x01, (byte)0x02, ...})
ResponseAPDU response = channel.transmit(command)