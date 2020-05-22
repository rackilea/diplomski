public void insert(Integer userId,MemberCardRecord oldCard, MemberCardRecord newCard) {
        CardUpgradeRecordBuilder
             .create(db().newRecord(CARD_UPGRADE))
             .userId(userId)
             .oldCardId(oldCard.getId())
             .newCardId(newCard.getId())
             .oldGrade(oldCard.getGrade())
             .newGrade(newCard.getGrade())
             .oldCardName(oldCard.getCardName())
             .newCardName(newCard.getCardName())
             .gradeCondition(newCard.getGradeCondition())
             .operate("Admin option")
             .build()
             .insert();
}