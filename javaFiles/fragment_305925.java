import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @ManyToOne
    @JoinColumn(name="idtest")
    private Test test ;

    // You probably don't want a reference to User here, as the User class
    // encapsulates the password, which you don't want to throw back and
    // forward across the network unnecessarily. But if the User class 
    // instead had a user name etc you wanted, you could use the same
    // @ManyToOne technique to reference a User object here if you needed.
    @Column(name="iduser")
    private int userId ;

    private int mark ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mark) {
            Mark other = (Mark)obj ;
            return Objects.equals(userId, other.userId)
                && Objects.equals(test, other.test)
                && mark == other.mark ;
        } else return false ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, test, mark);
    }
}