list1 = [LocalDate{112233} - hashcode: 33336787, LocalDate{223344} - hashcode: 12767201]
list2 = [LocalDate{112233} - hashcode: 31311199, LocalDate{112233} - hashcode: 13177912]
// generated output by the method containsAll(..)
LocalDate{112233} - hashcode: 31311199.equals(LocalDate{112233} - hashcode: 33336787)
LocalDate{112233} - hashcode: 13177912.equals(LocalDate{112233} - hashcode: 33336787)
list1.containsAll(list2) = true
// generated output by the method containsAll(..)
LocalDate{112233} - hashcode: 33336787.equals(LocalDate{112233} - hashcode: 31311199)
LocalDate{223344} - hashcode: 12767201.equals(LocalDate{112233} - hashcode: 31311199)
LocalDate{223344} - hashcode: 12767201.equals(LocalDate{112233} - hashcode: 13177912)
list2.containsAll(list1) = false