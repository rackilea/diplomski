StringBuilder sb = new StringBuilder();
sb.append(ID_PREFIX)
  .append(i)
  .append(',')
  .append(student.get(i))
  .append(' ');

for ( String courseName : sortedCourseNames ) {
    sb.append(courseName)
      .append(' ');
}

students.add( sb.toString() );