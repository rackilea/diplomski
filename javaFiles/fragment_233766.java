import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Note: potentially cycle graph - be careful of deep equals/hashCode/toString/etc.
 * Immutable
 */
public class Friend {

    public static class Builder {

        private final String name;
        private final Set<Builder> friends =
            new HashSet<Builder>();

        Builder(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Set<Builder> getFriends() {
            return friends;
        }

        void likes(final Builder... newFriends) {
            for (final Builder newFriend : newFriends)
            friends.add(newFriend);
        }

        public Map<String, Friend> createCircleOfFriends() {
            final IdentityHashMap<Builder, Friend> existing =
                new IdentityHashMap<Builder, Friend>();

            // Creating one friend creates the graph
            new Friend(this, existing);
            // after the call existingNodes contains all the nodes in the graph

            // Create map of the all nodes
            final Map<String, Friend> map =
                new HashMap<String, Friend>(existing.size(), 1f);
            for (final Friend current : existing.values()) {
                map.put(current.getName(), current);
            }

            return map;
        }
    }

    final String name;
    final Set<Friend> friends;

    private Friend(
            final Builder builder,
            final Map<Builder, Friend> existingNodes) {
        this.name = builder.getName();

        existingNodes.put(builder, this);

        final IdentityHashMap<Friend, Friend> friends =
            new IdentityHashMap<Friend, Friend>();
        for (final Builder current : builder.getFriends()) {
            Friend immutableCurrent = existingNodes.get(current);
            if (immutableCurrent == null) {
                immutableCurrent =
                    new Friend(current, existingNodes);
            }
            friends.put(immutableCurrent, immutableCurrent);
        }

        this.friends = Collections.unmodifiableSet(friends.keySet());
    }

    public String getName() {
        return name;
    }

    public Set<Friend> getFriends() {
        return friends;
    }


    /** Create string - prints links, but does not traverse them */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Friend ").append(System.identityHashCode(this)).append(" {\n");
        sb.append("  name = ").append(getName()).append("\n");
        sb.append("  links = {").append("\n");
        for (final Friend friend : getFriends()) {
            sb
            .append("     ")
            .append(friend.getName())
            .append(" (")
            .append(System.identityHashCode(friend))
            .append(")\n");
        }
        sb.append("  }\n");
        sb.append("}");
        return sb.toString();
    }

    public static void main(final String[] args) {
        final Friend.Builder john = new Friend.Builder("john");
        final Friend.Builder mary = new Friend.Builder("mary");
        final Friend.Builder susan = new Friend.Builder("susan");
        john
          .likes(mary, susan);
        mary
           .likes(susan, john);
        susan
           .likes(john);

        // okay lets build the immutable Friends
        final Map<String, Friend> friends = john.createCircleOfFriends();

        for(final Friend friend : friends.values()) {
            System.out.println(friend);
        }

        final Friend immutableJohn = friends.get("john");
    }
}