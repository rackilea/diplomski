@NamedQueries({
    @NamedQery(name = "customerByMailAndPassword"
               query = "select * from Customer where Email=? and Password=?")
})
@Entity
public class Customer {}