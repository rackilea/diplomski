Parent parent = this.getById(id);

    // Convert Date Type
    DateTime dayTimeEnd = new DateTime(date);
    dayTimeEnd = dayTimeEnd.plusHours(23);
    dayTimeEnd = dayTimeEnd.plusMinutes(55);
    Date dayEnd = dayTimeEnd.toDate();

    // Get all Tracking Data of this Date
    List<Child> ChildList = this.childRepository.findAllBytimeStampBetweenAndParent(date, dayEnd, parent);