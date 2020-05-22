ActionListener actionlistener= new ActionListener(); // This won't compile
// because it is an interface and it requires either a concrete implementation
// or it's method signatures filled out...

// This won't work, because java sees actionlistener() as method, which does not
// exist and the rest of the code does not make sense after it (to the compiler)
final Timer tiempo= new Timer(1000, actionlistener() 
{ 
    public void actionPerformed(ActionEvent e) 
    {   

    }
};