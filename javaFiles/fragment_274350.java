MarqueePanel panel = new MarqueePanel();
panel.setWrap(true);
panel.setWrapAmount(0);
panel.setPreferredWidth(250);

JLabel label = new JLabel( new ImageIcon( "heartbeat.jpg" ) );
panel.add( label );

frame.add( panel );