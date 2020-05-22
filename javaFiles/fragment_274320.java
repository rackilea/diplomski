public class Validation
{

   public static void main( String[] args )
   {
      SwingUtilities.invokeLater( new Runnable()
      {
         public void run()
         {
            JFrame frame = new JFrame();

            Box vbox = Box.createVerticalBox();

            JFormattedTextField jff = new JFormattedTextField( 0.0f );
            vbox.add(jff);
            JTextField jt = new JTextField( 20 );
            vbox.add( jt );
            JLabel value = new JLabel( jff.getValue().toString() );
            vbox.add( value );
            frame.add( vbox );
            JButton b = new JButton( "Get Value" );
            b.addActionListener( new ActionListener()
            {

               @Override
               public void actionPerformed( ActionEvent e )
               {
                  value.setText( jff.getValue().toString() );
               }
            } );
            JPanel p = new JPanel();
            p.add( b );
            frame.add( p, BorderLayout.SOUTH );

            frame.pack();
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setLocationRelativeTo( null );
            frame.setVisible( true );
         }
      } );
   }
}