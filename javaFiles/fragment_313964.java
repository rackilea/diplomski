rule setcat-1
when
  $students : List() 
    from collect (Student (age > 20, cat != "senior"))
then
  for( int i = 0; i < $students.size(); ++i ){
    Student s = (Student)$students.get( i );
    modify( s ){ setCat( "senior" ) }
  }
end

rule setcat-2
when
  $student : Student (age > 20, cat != "senior")
then
  modify( $student ){ setCat( "senior" ) }
end