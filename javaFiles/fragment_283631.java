...
@PersistenceContext
private EntityManager entityManager;
...

@Test
public void save() {
    saveDefaultEventAndCalendarFullyInitialized();
    event1ForCalendar1.setReminders(Collections.emptySet());

    eventRepository.save(event1ForCalendar1);
    entityManager.flush();

    Event actualEvent = eventRepository.findOneByCalendarIdAndId(calendar1.getId(), event1ForCalendar1.getId());

    event1ForCalendar1.setVersion(event1ForCalendar1.getVersion() + 1);
    assertThat(actualEvent, equalTo(event1ForCalendar1));
    assertThat(actualEvent.getReminders().size(), equalTo(0));

    List<Reminder> reminders = reminderRepository.findAll();
    assertThat(reminders.size(), equalTo(0));
}