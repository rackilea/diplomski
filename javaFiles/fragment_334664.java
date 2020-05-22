class Component
{
    public void paint( Graphics g ) {}
}

class Container extends Component
{
    // inherits paint from Component but doesn't override it
}