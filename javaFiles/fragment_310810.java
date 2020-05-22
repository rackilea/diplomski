StudentResponse  response = new StudentResponse();
response.student = new Student[list.size()];
for (int in = 0; in < list.size(); in++) {
{
    Student data = (TopListsQuoteData) list.get(in);
    response. student[in] = data;
}