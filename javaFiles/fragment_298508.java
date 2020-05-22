public class MyActionSubPub
{
    private List<ActionListener> downstreams = new ArrayList<ActionListener>();
    public MyActionSubPub( AbstractButton(or whatever) button )
    {
        button.addActionListener( this );
    }
    public addActionListener( ActionListener listener )
    {
        downstreams.add( listener );
    }
    public void actionPerformed( ActionEvent event )
    {
        ... do your stuff ...
        ... loop through all downstreams, call actionPerformed on each...
    }
}