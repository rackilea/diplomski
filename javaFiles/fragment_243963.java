public List<Reminder> filterReminderByTheme(String theme) {
    result = elements.values()
            .stream()
            .filter(value -> value instanceof Reminder 
                                   && theme.equals(((Reminder)value).getTheme()))
            .collect(Collectors.toList());
    return result;
}