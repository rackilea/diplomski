@ElementCollection(targetClass = Days.class)
@CollectionTable(name = "days", joinColumns = @JoinColumn(name = "rule_id"))
@Column(name = "daysOfWeek", nullable = false)
@Enumerated(EnumType.STRING)
public Set<Days> getDays() {
    return days;
}