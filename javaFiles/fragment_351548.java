for(Person p : collection{
    pstmnt.setString(1,p.getName());
    pstmnt.setString(2,p.getSurname());
    pStmnt.setInt(3,p.getId());
    pStmnt.setString(3,p.getPhone());

    pStmnt.execteUpdate();
}