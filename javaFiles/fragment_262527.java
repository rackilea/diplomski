enum TaskProperty {
    TITLE(comparatorForTitle), 
    DATE(comparatorForDate), ...
}

// Using it:
tasks.stream().sorted(TaskProperty.TITLE.getComparator()).forEach(...);