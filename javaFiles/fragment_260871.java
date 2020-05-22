public class Pessoa
{
    @Override
    public boolean equals(Pessoa pessoa)
    {
        //You check if the fields are equal, if not, return false
        if(this.field != pessoa.field) return false;
        else if(this.field2 != pessoa.field2) return false;

        return true;
    }
}