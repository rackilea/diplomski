public Patient(final String ptNo, final String ptName,
        final String procDate, final int procType, final String injury,
        final String drName) throws IOException
{
    Patient.ptNo = getPtNo();
    Patient.ptName = getPtName();
    Patient.procDate = getProcDate();
    Patient.procType = getProcType();
    Patient.injury = getPtNotes();
    Patient.drName = getDrName();
}