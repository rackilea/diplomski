public void changeDisplay(Events e) {
    evTitle.setText(""+e.getEventName());
    evWhen.setText("When: "+ e.getEventDate());
    evWhere.setText("Where: "+ e.getEventVenue());
    evDescription.setText("Description: "+ e.getEventDetail());
    evOpportunity.setText("Opporunity: "+ e.getEventOpportunity());
    evMoreDet.setText("More Details: "+ e.getEventMoreDetails());
}