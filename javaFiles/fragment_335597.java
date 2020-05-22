@Entity
@XmlRootElement
@Table(name="Users")
public class User implements Serializable {

    @XmlWrapperElement("tweets")
    public Collection<Tweet> getTweets() {
        List<Tweet> temp = new ArrayList<Tweet>(tweets);
        Collections.reverse(temp);
        return temp;
    }
}