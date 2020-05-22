boolean validateEffectiveIn(PersonDTO personDTO, TransactionLogDTO logDTO) {
    ...
    return modifyPerson; // true or false
}

...
modifyPerson = false;
modifyPerson |= validateEffectiveIn(person1DTO, logDTO);
modifyPerson |= validateEffectiveIn(person2DTO, logDTO);