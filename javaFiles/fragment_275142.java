@Entity
@Table(name = "utente")
public class Utente extends UtenteBase
{
   public Utente {}
}

@Entity
@Table(name = "utente")
public class UtenteSub extends UtenteBase
{
    @Transient
    private String newField;
}