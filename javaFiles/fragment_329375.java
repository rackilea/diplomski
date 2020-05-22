public class CreatorValidation implements ValidationCondition {

    public Optional<String> validate(final Post post, final Session session) {
        if (post.getCreator().equals(session.getUser()) {
            return Optional.empty();
        }
        return Optional.of("You should be the owner of the post");
    }
}