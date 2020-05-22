final List<String> errors = new ArrayList<>();

for (final ValidationCondition condition : conditions) {
    final Optional<String> error = condition.validate(post, session);
    if (error.isPresent()) {
        errors.add(error.get());
    }
}