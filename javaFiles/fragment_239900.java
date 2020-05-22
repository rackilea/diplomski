class Group extends Character { 
    private Collection<Character> m_members;
    Group( String id,Position p, Collection<Character> members ) {
        super( id, p ); // Superclass constructor for the *group*.
        m_members = new ArrayList<>( members ); // Defensive copy
    } 
}