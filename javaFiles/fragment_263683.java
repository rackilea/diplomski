String createdDate = comment.getCreatedDateTime();
SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
try {
    Date parsedDate = defaultDateFormat.parse(createdDate);
    SimpleDateFormat finalDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
    createdDate = finalDateFormat.format(parsedDate);
} catch (ParseException ex) {
    ex.printStackTrace();
}
mCommentDate.setText(createdDate);