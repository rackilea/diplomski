interface IEmployee
{

    void workHard ();  
    void procrastinate ();

    class DefaultEmployee implements IEmployee 
    {
        void workHard () { procrastinate(); };
        void procrastinate () {};
    }

}